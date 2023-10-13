import java.io.*;
import java.util.Stack;

public class Main {
  static int N;
  static int[] dp = new int[1000001];
  static int[] parent = new int[1000001];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    int next;
    for (int i = 1; i <= N; i++) {
      // 1. x * 3
      next = i * 3;
      if (next <= N) {
        if (dp[next] == 0 || (dp[i] + 1 < dp[next])) {
          dp[next] = dp[i] + 1;
          parent[next] = i;
        }
      }
      // 2. x * 2
      next = i * 2;
      if (next <= N) {
        if (dp[next] == 0 || (dp[i] + 1 < dp[next])) {
          dp[next] = dp[i] + 1;
          parent[next] = i;
        }
      }
      // 3. ++x
      next = i + 1;
      if (next <= N) {
        if (dp[next] == 0 || (dp[i] + 1 < dp[next])) {
          dp[next] = dp[i] + 1;
          parent[next] = i;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(dp[N]).append("\n").append(N).append(" ");

    int index = N;
    while (index != 1) {
      sb.append(parent[index]).append(" ");
      index = parent[index];
    }

    System.out.println(sb);
  }
}
