package P9461;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static long[] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P9461/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        dp = new long[101];

        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;
        dp[6] = 3;
        dp[7] = 4;
        dp[8] = 5;
        dp[9] = 7;
        dp[10] = 9;

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            if (dp[N] != 0) {
                sb.append(dp[N]).append("\n");
            } else {
                for (int i = 11; i <= N; i++) {
                    dp[i] = dp[i - 2] + dp[i - 3];
                }
                sb.append(dp[N]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
