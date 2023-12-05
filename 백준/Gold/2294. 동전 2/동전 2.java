import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N, K;

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = stoi(st.nextToken());
    K = stoi(st.nextToken());

    int[] coins = new int[N];
    int[] dp = new int[100001];
    Arrays.fill(dp, Integer.MAX_VALUE - 1);

    for (int i = 0; i < N; i++) {
      coins[i] = stoi(br.readLine());
      dp[coins[i]] = 1;
    }

    for (int i = 0; i <= K; i++) {
      for (int coin : coins) {
        if (i < coin) continue;

        dp[i] = Math.min(dp[i], dp[i - coin] + dp[coin]);
      }
    }

    System.out.println((dp[K] == Integer.MAX_VALUE - 1) ? -1 : dp[K]);
  }
}
