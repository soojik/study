package P10844_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[][] dp;
    static long mod = 1000000000;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P10844/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        long answer = 0;
        for (int i = 1; i <= 9; i++) {
            answer += calc_stair(N, i);
        }

        System.out.println(answer % mod);
    }

    static long calc_stair(int depth, int val) {
        if (depth == 1) {
            return dp[depth][val] % mod;
        }

        if (dp[depth][val] == 0) {
            if (val == 0) {
                dp[depth][val] = calc_stair(depth - 1, 1);
            } else if (val == 9) {
                dp[depth][val] = calc_stair(depth - 1, 8);
            } else {
                dp[depth][val] = calc_stair(depth - 1, val - 1) + calc_stair(depth - 1, val + 1);
            }
        }

        return dp[depth][val] % mod;
    }
}
