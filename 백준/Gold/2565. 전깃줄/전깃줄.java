import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int[][] wires = new int[N + 1][2];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      wires[i][0] = Integer.parseInt(st.nextToken());
      wires[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(wires, (w1, w2) -> w1[0] - w2[0]);

    int[] dp = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      for (int j = i; j <= N; j++) {
        if (wires[i][1] < wires[j][1] && dp[i] + 1 >= dp[j]) {
          dp[j] = dp[i] + 1;
        }
      }
    }

    int ans = 0;
    for (int i = 1; i <= N; i++) {
      ans = Math.max(ans, dp[i]);
    }

    System.out.println(N - (ans + 1));
  }
}
