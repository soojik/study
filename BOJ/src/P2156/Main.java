package P2156;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[] wine;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P2156/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        wine = new long[10001];
        for (int i = 1; i <= N; i++) {
            wine[i] = Long.parseLong(br.readLine());
        }

        dp = new long[10001];

        dp[0] = 0;
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + wine[i - 1] + wine[i], dp[i - 2] + wine[i]));
        }
        
        System.out.println(dp[N]);
    }
}
