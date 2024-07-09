import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] map;
  static int[][] dp;
  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};
  static int N, M;
  static int ans = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N + 1][M + 1];
    dp = new int[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        dp[i][j] = -1;
      }
    }

    System.out.println(dfs(1, 1));
  }

  static int dfs(int r, int c) {
    if (r == N && c == M) {
      return 1;
    }

    // 이미 한번 탐색한 곳이라면 넘어가기
    if (dp[r][c] != -1) return dp[r][c];

    dp[r][c] = 0;
    int nr, nc;
    for (int i = 0; i < 4; i++) {
      nr = r + dr[i];
      nc = c + dc[i];

      if (1 <= nr && nr <= N && 1 <= nc && nc <= M) {
        // 내리막길
        if (map[r][c] <= map[nr][nc]) continue;
        // {r, c} 좌표에서 도착지로 갈 수 있는 경우의 수 
        dp[r][c] += dfs(nr, nc);
      }
    }
    
    return dp[r][c];
  }
}
