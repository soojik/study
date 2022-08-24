package DAY05.P1837;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static String P;
    static int K;
    static boolean[] isNotPrime;
    static List<Integer> primes;

    public static void main(String[] args) throws IOException, FileNotFoundException {
        System.setIn(new FileInputStream("src/DAY05/P1837/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        P = st.nextToken();
        K = Integer.parseInt(st.nextToken());
        isNotPrime = new boolean[K+1];
        primes = new ArrayList<>();

        for (int i = 2; i <= K; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
                for (int j = i * 2; j < K + 1; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int prime : primes) {
            if (prime >= K) {
                break;
            }
            if (check(prime)) {
                System.out.println("BAD " + prime);
                return;
            }
        }
        System.out.println("GOOD");
    }

    static public boolean check(int x) {
        int pre = 0;
        for (int j = 0; j < P.length(); j++) {
            pre = (pre * 10 + (P.charAt(j) - '0')) % x;
        }
        return pre == 0;
    }
}
