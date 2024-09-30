import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int N;
  static int[][] map;
  static boolean[][] visited;
  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};
  static int stoi(String s) {
    return Integer.parseInt(s);}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = stoi(br.readLine());
    map = new int[N][N];
    visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      String input_str = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = input_str.charAt(j) == 'B' ? -1 : input_str.charAt(j) == 'R' ? 1 : 0;
      }
    }

    StringBuffer sb = new StringBuffer();
    int[] answer = {0, 0};
    for (int b=0;b<=1;b++) {
      visited = new boolean[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!visited[i][j]) {
            ++answer[b];
            bfs(b == 1, map[i][j] < 0, i, j);
          }
        }
      }
    }

    for (int a : answer) sb.append(a).append(" ");

    System.out.println(sb);
  }

  static void bfs(boolean isColourBlind, boolean isBlue, int r, int c) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{r, c});

    while (!q.isEmpty()) {
      int[] curr = q.poll();

      int nr, nc;
      for (int i = 0; i < 4; i++) {
        nr = curr[0] + dr[i];
        nc = curr[1] + dc[i];

        if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]) {
          if (isColourBlind) {
            if ((isBlue && map[nr][nc] < 0) || (!isBlue && map[nr][nc] >= 0)) {
              visited[nr][nc] = true;
              q.add(new int[]{nr, nc});
            }
          }
          else {
            if (map[nr][nc] == map[r][c]) {
              visited[nr][nc] = true;
              q.add(new int[]{nr, nc});
            }
          }
        }
      }
    }
  }
}
