import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[][] box;
  static int[][] cnt;
  static boolean[][] visited;

  static Queue<int[]> q = new LinkedList<>();
  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, 1, 0, -1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    box = new int[M][N];
    cnt = new int[M][N];
    visited = new boolean[M][N];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        box[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (box[i][j] == 1) {
          q.add(new int[]{i, j});
        }
      }
    }

    bfs();

    int answer = 0;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (cnt[i][j] == 0 && box[i][j] == 0) {
          System.out.println(-1);
          return;
        }
        answer = Math.max(answer, cnt[i][j]);
      }
    }

    System.out.println(answer);
  }

  static void bfs() {
    while (!q.isEmpty()) {
      int[] curr = q.poll();

      int nr, nc;
      for (int i = 0; i < 4; i++) {
        nr = curr[0] + dr[i];
        nc = curr[1] + dc[i];

        if (0 <= nr && nr < M && 0 <= nc && nc < N && !visited[nr][nc]) {
          if (box[nr][nc] == 0) {
            visited[nr][nc] = true;
            q.add(new int[]{nr, nc});
            cnt[nr][nc] = cnt[curr[0]][curr[1]] + 1;
          }
        }
      }
    }
  }
}
