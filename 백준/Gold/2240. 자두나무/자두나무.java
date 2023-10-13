import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int T = stoi(st.nextToken());
    int W = stoi(st.nextToken());

    int[] info = new int[T + 1];
    info[0] = 1;
    int[][] dp = new int[T + 1][W + 1];
    for (int i = 1; i <= T; i++) {
      info[i] = stoi(br.readLine());
    }

    int answer = 0;

    for (int i = 1; i <= T; i++) {
      for (int j = 0; j <= W; j++) {
        if (j == 0) {
          if (info[i] == 1) {
            dp[i][j] = dp[i - 1][j] + 1;
          } else {
            dp[i][j] = dp[i - 1][j];
          }
          continue;
        }

        if (j % 2 == 0) {
          if (info[i] == 1) {
            dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1]);
          } else {
            dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
          }
        }

        else {
          if (info[i] == 2) {
            dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1]);
          } else {
            dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
          }
        }

        answer = Math.max(answer, dp[i][j]);
      }
    }

    System.out.println(answer);

  }
}