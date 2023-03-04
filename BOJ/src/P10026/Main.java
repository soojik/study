package P10026;

import java.lang.*;
import java.io.*;

class Main {
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};

  static int N;
  static char[][] map;
  static boolean[][] visit;

  public static void main (String[] args) throws IOException {
    System.setIn(new FileInputStream("BOJ/src/P10026/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    map = new char[N][N];

    for(int i=0;i<N;i++) {
      String input_str = br.readLine();
      for (int j=0;j<N;j++) {
        map[i][j] = input_str.charAt(j);
      }
    }

    visit = new boolean[N][N];
    int cnt = 0;

    char target;
    for (int i=0;i<N;i++) {
      for (int j=0;j<N;j++) {
        if (!visit[i][j]) {
          target = map[i][j];
          cnt++;
          visit[i][j] = true;
          DFS(i, j, target);
        }
      }
    }

    visit = new boolean[N][N];
    int cnt_ = 0;
    for (int i=0;i<N;i++) {
      for (int j=0;j<N;j++) {
        if (!visit[i][j]) {
          target = map[i][j];
          cnt_++;
          visit[i][j] = true;
          DFS_2(i, j, target == 'B');
        }
      }
    }

    System.out.println(cnt);
    System.out.println(cnt_);

  }

  static void DFS(int x, int y, char target) {

    for (int i=0;i<4;i++) {
      int next_x = x + dx[i];
      int next_y = y + dy[i];

      if (0 <= next_x && next_x < N && 0 <= next_y && next_y < N) {
        // target 일때
        if (!visit[next_x][next_y]) {
          if (map[next_x][next_y] == target) {
            visit[next_x][next_y] = true;
            DFS(next_x, next_y, target);
          }
        }
      }
    }
  }

  static void DFS_2(int x, int y, boolean isB) {

    for (int i=0;i<4;i++) {
      int next_x = x + dx[i];
      int next_y = y + dy[i];

      if (0 <= next_x && next_x < N && 0 <= next_y && next_y < N) {
        // target 일때
        if (!visit[next_x][next_y]) {
          if (isB && map[next_x][next_y] == 'B') {
            visit[next_x][next_y] = true;
            DFS_2(next_x, next_y, true);
          } else if (!isB && (map[next_x][next_y] == 'R' || map[next_x][next_y] == 'G')) {
            visit[next_x][next_y] = true;
            DFS_2(next_x, next_y, false);
          }
        }
      }
    }
  }
}