import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};
  static int N, L, R;
  static int[][] countries;
  static boolean[][] visited;
  static List<int[]> unit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    countries = new int[N][N];
    visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        countries[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int answer = 0;
    while (true) {
      visited = new boolean[N][N];
      boolean flag = false;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (visited[i][j]) continue;
          unit = new ArrayList<>();
          unit.add(new int[]{i, j});
          visited[i][j] = true;
          int sum = dfs(i, j);
          if (1 < unit.size()) {
            flag = true;
            for (int[] u : unit) {
              countries[u[0]][u[1]] = sum / unit.size();
            }
          }
        }
      }

      if (!flag) break;
      ++answer;
    }

    System.out.println(answer);
  }

  static int dfs(int r, int c) {
    int sum = countries[r][c];
    int nr, nc;
    for (int i = 0; i < 4; i++) {
      nr = r + dr[i];
      nc = c + dc[i];

      if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]) {
        int diff = Math.abs(countries[nr][nc] - countries[r][c]);
        if (L <= diff && diff <= R) {
          visited[nr][nc] = true;
          unit.add(new int[]{nr, nc});
          sum += dfs(nr, nc);
        }
      }
    }

    return sum;
  }
}
