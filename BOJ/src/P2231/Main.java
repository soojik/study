package P2231;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean check;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2231/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int sum, tmp, i;
        check = false;
        for (i = 0; i < N; i++) {
            tmp = sum = i;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }

            if (sum == N) {
                System.out.println(i);
                return;
            }
        }
        if (i == N) {
            System.out.println(0);
        }
    }
}
