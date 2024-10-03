import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] coins = new int[N];
    int[] dp = new int[100001];
    Arrays.fill(dp, 100001);
    for (int i = 0; i < N; i++) {
      coins[i] = Integer.parseInt(br.readLine());
      dp[coins[i]] = 1;
    }

    for (int i = 0; i <= K; i++) {
      for (int c : coins) {
        if (i-c < 0) continue;
        dp[i] = Math.min(dp[i], dp[i - c] + dp[c]);
      }
    }

    System.out.println(dp[K] == 100001 ? -1 : dp[K]);
  }
}
