package P1932;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] triangle;
    static int[][] dp;
    static int answer;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P1932/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        triangle = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][N];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                answer = Math.max(dp[i][j], answer);
            }
        }

        System.out.println(answer);
    }
}
