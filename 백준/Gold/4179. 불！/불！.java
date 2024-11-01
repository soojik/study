import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int R, C;
  static char[][] map;
  static Queue<Info> q = new LinkedList<>();
  static boolean[][] visited;
  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, -1, 0, 1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new char[R][C];
    visited = new boolean[R][C];

    int[] start = new int[2];

    for (int i = 0; i < R; i++) {
      String input_str = br.readLine();
      for (int j = 0; j < C; j++) {
        if ((map[i][j] = input_str.charAt(j)) == 'F') {
          q.add(new Info(i, j, 0, 'F'));
        }
        if (map[i][j] == 'J') {
          start = new int[]{i, j};
        }
      }
    }

    q.add(new Info(start[0], start[1], 0, 'J'));

    bfs();
  }

  static void bfs() {
    while (!q.isEmpty()) {
      Info curr = q.poll();

      int nr, nc;
      for (int i = 0; i < 4; i++) {
        nr = curr.r + dr[i];
        nc = curr.c + dc[i];

        if (0 <= nr && nr < R && 0 <= nc && nc < C) {
          if (curr.status == 'F') {
            if (map[nr][nc] == '.' || map[nr][nc] == 'J') {
              q.add(new Info(nr, nc, 0, 'F'));
              map[nr][nc] = 'F';
            }
          } else if (curr.status == 'J' && !visited[nr][nc]) {
            if (map[nr][nc] == '.') {
              visited[nr][nc] = true;
              q.add(new Info(nr, nc, curr.cnt + 1,  'J'));
              map[nr][nc] = 'J';
            }
          }
        }
        else {
          if (curr.status == 'J') {
            System.out.println(curr.cnt + 1);
            return;
          }
        }
      }
    }

    System.out.println("IMPOSSIBLE");
  }
}

class Info {
  int r, c, cnt;
  char status;

  public Info(int r, int c, int cnt, char status) {
    this.r = r;
    this.c = c;
    this.cnt = cnt;
    this.status = status;
  }
}