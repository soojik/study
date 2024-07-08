import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[][] sand;
  static boolean[][] visited;
  static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
  static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
  static int ans = 0;
  static Queue<int[]> curr_round = new LinkedList<>();
  static Queue<int[]> next_round = new LinkedList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    sand = new int[N][M];
    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      String input_line = br.readLine();
      for (int j = 0; j < M; j++) {
        sand[i][j] = input_line.charAt(j) == '.' ? 0 : input_line.charAt(j) - '0';
        if (sand[i][j] == 0 && !visited[i][j]) {
          visited[i][j] = true;
          next_round.add(new int[]{i, j});
        }
      }
    }

    bfs();

    System.out.println(ans - 1);
  }

  static void bfs() {
    while (!next_round.isEmpty()) {
      ++ans;
      curr_round = next_round;
      next_round = new LinkedList<>();
      while (!curr_round.isEmpty()) {
        int[] curr = curr_round.poll();

        int cr = curr[0], cc = curr[1];

        int nr, nc;
        for (int i = 0; i < 8; i++) {
          nr = cr + dr[i];
          nc = cc + dc[i];

          if (0 <= nr && nr < N && 0 <= nc && nc < M) {
            if (isBreakable(nr, nc) && !visited[nr][nc]) {
              visited[nr][nc] = true;
              next_round.add(new int[]{nr, nc});
            }
          }
        }
      }

      for (int i = 0; i < next_round.size(); i++) {
        int[] breakableSand = next_round.poll();
        sand[breakableSand[0]][breakableSand[1]] = 0;
        next_round.add(breakableSand);
      }
    }
  }

  static boolean isBreakable(int r, int c) {
    int nr, nc;
    int cnt = 0;
    for (int i = 0; i < 8; i++) {
      nr = r + dr[i];
      nc = c + dc[i];
      if (0 <= nr && nr < N && 0 <= nc && nc < M && sand[nr][nc] == 0) {
        ++cnt;
      }
    }

    // 주변 모래가 튼튼함 정도보다 같거나 많다면 부숴짐
    return sand[r][c] <= cnt;
  }
}
