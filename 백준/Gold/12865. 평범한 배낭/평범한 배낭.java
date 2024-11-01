import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] bag;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bag = new int[N+1][2];

        bag[0][0] = bag[0][1] = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            bag[i][0] = Integer.parseInt(st.nextToken());
            bag[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[K+1][N+1];
        for (int i = 0; i <= N; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= K; i++) { // 얼마나 담을 수 있는지 순회
            for (int j = 1; j <= N; j++) {  // j번째 배낭 탐색

                int curr_w = bag[j][0];
                int curr_v = bag[j][1];

                if (curr_w <= i) {
                    dp[i][j] = Math.max(dp[i][j-1], curr_v + dp[i-curr_w][j-1]);
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, dp[i+1][j+1]);
            }
        }

        System.out.println(answer);
    }
}