import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static boolean[][] map;
  static boolean[][][] visited;
  static int answer = -1;
  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, -1, 0, 1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new boolean[N][M];
    visited = new boolean[N][M][2];

    for (int i = 0; i < N; i++) {
      String input_str = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = input_str.charAt(j) == '0';
      }
    }

    bfs();
    System.out.println(answer);
  }

  static void bfs() {
    // r, c, cnt, 부술수있는벽
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{0, 0, 1, 1});
    visited[0][0][1] = true;

    while (!q.isEmpty()) {
      int[] curr = q.poll();

      if (curr[0] == N - 1 && curr[1] == M - 1) {
        answer = curr[2];
        return;
      }

      int nr, nc;
      for (int i = 0; i < 4; i++) {
        nr = curr[0] + dr[i];
        nc = curr[1] + dc[i];

        if (0 <= nr && nr < N && 0 <= nc && nc < M) {
          if (!map[nr][nc]) {
            if (0 < curr[3] && !visited[nr][nc][0]) {
              visited[nr][nc][0] = true;
              q.add(new int[]{nr, nc, curr[2] + 1, curr[3] - 1});
            }
          }
          else {
            if (visited[nr][nc][curr[3]]) continue;
            visited[nr][nc][curr[3]] = true;
            q.add(new int[]{nr, nc, curr[2] + 1, curr[3]});
          }
        }
      }
    }
  }

}
