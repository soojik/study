import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n, m;
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    int[][] map = new int[n + 1][m + 1];

    for (int r = 1; r <= n; r++) {
      String input_str = br.readLine();
      for (int c = 1; c <= m; c++) {
        map[r][c] = input_str.charAt(c-1) - '0';
      }
    }

    if (n == 1 && m == 1) {
      System.out.println(map[n][m] * map[n][m]);
      return;
    }

    int[][] dp = new int[n + 1][m + 1];
    int answer = 0;

    for (int r = 1; r <= n; r++) {
      for (int c = 1; c <= m; c++) {
        if (r == 1 && c == 1) {
          dp[r][c] = map[r][c];
          continue;
        }
        if (map[r][c] == 0) continue;
        dp[r][c] = Math.min(dp[r - 1][c], Math.min(dp[r][c - 1], dp[r - 1][c - 1])) + 1;
        answer = Math.max(answer, dp[r][c]);
      }
    }

    System.out.println(answer * answer);
  }
}
