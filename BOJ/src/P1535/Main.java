package P1535;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] hp;
    static int[] joy;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P1535/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        hp = new int[N+1];
        joy = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1][100];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 99; j++) {
                if (hp[i] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j - hp[i]] + joy[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][99]);

    }
}
