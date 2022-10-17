package P1904;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P1904/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[1000001];

        dp[0] = dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            if (dp[i] >= 15746) {
                dp[i] %= 15746;
            }
        }

        System.out.println(dp[N]);
    }
}
