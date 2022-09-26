package P11047;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] coins;
    static int max = 0;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P11047/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            if (coins[i] <= K) {
                max = i;
            }
        }

        int sum = K;
        for (int i = max; i >= 0; i--) {
            while (sum >= coins[i]) {
                sum -= coins[i];
                answer++;
            }
        }

        System.out.println(answer);
    }
}
