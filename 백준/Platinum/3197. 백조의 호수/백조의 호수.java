import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, -1, 0, 1};
  static int R, C;
  static char[][] map;
  static boolean[][] visited_water;
  static boolean[][] visited_swan;
  static int[][] swan = new int[2][2];
  static Queue<int[]> curr_water = new LinkedList<>();
  static Queue<int[]> next_water = new LinkedList<>();
  static Queue<int[]> curr_swan = new LinkedList<>();
  static Queue<int[]> next_swan = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new char[R][C];
    visited_water = new boolean[R][C];
    visited_swan = new boolean[R][C];

    int swan_idx = 0;
    for (int i = 0; i < R; i++) {
      String input_str = br.readLine();
      for (int j = 0; j < C; j++) {
        map[i][j] = input_str.charAt(j);
        if (map[i][j] == '.') {
          next_water.add(new int[]{i, j});
          visited_water[i][j] = true;
        }
        if (map[i][j] == 'L') {
          swan[swan_idx++] = new int[]{i, j};
          map[i][j] = '.';
          next_water.add(new int[]{i, j});
          visited_water[i][j] = true;
        }
      }
    }

    next_swan.add(new int[]{swan[0][0], swan[0][1]});
    visited_swan[swan[0][0]][swan[0][1]] = true;

    int ans = 0;

    if (check()) {
      System.out.println(ans);
      return;
    }

    while (true) {
      ++ans;
      melting();
      if (check()) {
        System.out.println(ans);
        return;
      }
    }
  }

  static void melting() {
    curr_water = next_water;
    next_water = new LinkedList<>();
    while (!curr_water.isEmpty()) {
      int[] curr = curr_water.poll();

      int nr, nc;
      for (int i = 0; i < 4; i++) {
        nr = curr[0] + dr[i];
        nc = curr[1] + dc[i];

        if (0 <= nr && nr < R && 0 <= nc && nc < C && !visited_water[nr][nc]) {
          if (map[nr][nc] == '.') continue;
          visited_water[nr][nc] = true;
          if (map[nr][nc] == 'X') {
            map[nr][nc] = '.';
            next_water.add(new int[]{nr, nc});
          }
        }
      }
    }
  }

  static boolean check() {
    curr_swan = next_swan;
    next_swan = new LinkedList<>();

    while (!curr_swan.isEmpty()) {
      int[] curr = curr_swan.poll();

      int nr, nc;
      for (int i = 0; i < 4; i++) {
        nr = curr[0] + dr[i];
        nc = curr[1] + dc[i];

        if (nr == swan[1][0] && nc == swan[1][1]) {
          return true;
        }

        if (0 <= nr && nr < R && 0 <= nc && nc < C && !visited_swan[nr][nc]) {
          visited_swan[nr][nc] = true;
          if (map[nr][nc] == '.') {
            curr_swan.add(new int[]{nr, nc});
          } else if (map[nr][nc] == 'X') {
            next_swan.add(new int[]{nr, nc});
          }
        }
      }
    }
    return false;
  }
}