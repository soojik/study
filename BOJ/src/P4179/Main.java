package P4179;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int R, C;
  static char[][] map;
  static int[][] cnt;

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("BOJ/src/P4179/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new char[R][C];
    cnt = new int[R][C];
    Info first_J = null;

    Queue<Info> q = new LinkedList<>();

    for (int i = 0; i < R; i++) {
      String input_str = br.readLine();
      for (int j = 0; j < C; j++) {
        map[i][j] = input_str.charAt(j);
        if (map[i][j] == 'F') {
          q.add(new Info(i, j, 'F'));
        }
        if (map[i][j] == 'J') {
          first_J = new Info(i, j, 'J');
        }
      }
    }
    q.add(first_J);

    while (!q.isEmpty()) {
      Info curr = q.poll();

      for (int i = 0; i < 4; i++) {
        int next_x = curr.x + dx[i];
        int next_y = curr.y + dy[i];

        if (0 <= next_x && next_x < R && 0 <= next_y && next_y < C) {
          // 현재 상태가 불(F)일 때
          if (curr.type == 'F') {
            // 불이 갈 수 있는 곳? == . / J
            if (map[next_x][next_y] == '.' || map[next_x][next_y] == 'J') {
              map[next_x][next_y] = 'F';
              q.add(new Info(next_x, next_y, 'F'));
            }
          }
          // 현재 상태가 지훈이 위치(J)이면서 아직 안간 곳일 때
          else if (curr.type == 'J' && cnt[next_x][next_y] == 0) {
            if (map[next_x][next_y] == '.') {
              cnt[next_x][next_y] = cnt[curr.x][curr.y] + 1;
              map[next_x][next_y] = 'J';
              q.add(new Info(next_x, next_y, 'J'));
            }
          }
        } else {
          if (curr.type == 'J') {
            System.out.println(cnt[curr.x][curr.y] + 1);
            return;
          }
        }
      }
    }

    System.out.println("IMPOSSIBLE");
  }
}

class Info {
  int x;
  int y;
  char type;

  public Info(int x, int y, char type) {
    this.x = x;
    this.y = y;
    this.type = type;
  }
}