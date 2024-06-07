import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[][] arr;
  static int last_standing_cheese = 0;
  static int curr_cheese = 0;
  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        if (arr[i][j] == 1) ++curr_cheese;
      }
    }

    int round = 0;

    while (0 < curr_cheese) {
      ++round;
      last_standing_cheese = curr_cheese;
      bfs();
    }

    System.out.println(round);
    System.out.println(last_standing_cheese);
  }

  static void bfs() {
    Queue<int[]> q = new LinkedList<>();
    boolean[][] visited = new boolean[N][M];
    q.add(new int[]{0, 0});
    visited[0][0] = true;

    while (!q.isEmpty()) {
      int[] curr = q.poll();
      int nr, nc;
      for (int i = 0; i < 4; i++) {
        nr = curr[0] + dr[i];
        nc = curr[1] + dc[i];

        if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;
        visited[nr][nc] = true;
        if (arr[nr][nc] == 1) {
          arr[nr][nc] = 0;
          --curr_cheese;
          continue;
        }
        q.add(new int[]{nr, nc});
      }
    }
  }
}
