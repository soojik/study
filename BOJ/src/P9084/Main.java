package P9084;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P9084/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            // 사용할 수 있는 동전
            int[] coins = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int target = Integer.parseInt(br.readLine());

            //

            int[] dp = new int[target + 1];
            dp[0] = 1;

            for (int i = 1; i <= N; i++) {
                int coin = coins[i];
                for (int j = coin; j <= target; j++) {
                    dp[j] += dp[j - coin];
                }
            }

            sb.append(dp[target]).append("\n");
        }

        System.out.println(sb);
    }
}
