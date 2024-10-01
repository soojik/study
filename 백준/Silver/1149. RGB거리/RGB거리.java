import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[][] houses = new int[N][3];
    int[][] dp = new int[N][3];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        houses[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dp[0][0] = houses[0][0];
    dp[0][1] = houses[0][1];
    dp[0][2] = houses[0][2];
    for (int i = 1; i < N; i++) {
      for (int j = 0; j < 3; j++) {
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < 3; k++) {
          if (j == k) continue;
          min = Math.min(dp[i - 1][k] + houses[i][j], min);
        }
        dp[i][j] = min;
      }
    }

    System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
  }
}
