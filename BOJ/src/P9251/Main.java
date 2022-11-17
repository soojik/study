package P9251;

import java.io.*;

public class Main {
    static String str1;
    static String str2;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P9251/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();

        dp = new int[1001][1001];

        for (int i=1;i<=len1;i++) {
            char now1 = str1.charAt(i-1);

            for (int j=1;j<=len2;j++) {
                char now2 = str2.charAt(j-1);

                if (now1 == now2) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }

        }

        int answer = 0;

        for (int i=1;i<=len1;i++) {
            for (int j=1;j<=len2;j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }
}