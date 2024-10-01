import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] dr = {1, 0};
  static int[] dc = {0, 1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[][] map = new int[110][110];
    long[][] dp = new long[110][110];
    dp[0][0] = 1;

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (dp[i][j] == 0 || (i == N - 1 && j == N - 1)) continue;
        for (int k = 0; k < 2; k++) {
          dp[i + dr[k] * map[i][j]][j + dc[k] * map[i][j]] += dp[i][j];
        }
      }
    }

    System.out.println(dp[N-1][N-1]);
  }
}
