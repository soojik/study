package P7562;

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
  static int[] dx = {-2, -2, 2, 2, -1, -1, 1, 1};
  static int[] dy = {-1, 1, -1, 1, -2, 2, -2, 2};

  static int N;
  static boolean[][] visit;
  static int[][] cnt;

  static int start_x;
  static int start_y;

  static int target_x;
  static int target_y;

  static Queue<Knight> q;

  public static void main (String[] args) throws IOException {
    System.setIn(new FileInputStream("BOJ/src/P7562/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int test = Integer.parseInt(br.readLine());

    for (int t=0;t<test;t++) {
      N = Integer.parseInt(br.readLine());

      visit = new boolean[N][N];

      StringTokenizer st = new StringTokenizer(br.readLine());
      start_x = Integer.parseInt(st.nextToken());
      start_y = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      target_x = Integer.parseInt(st.nextToken());
      target_y = Integer.parseInt(st.nextToken());

      visit[start_x][start_y] = true;

      cnt = new int[N][N];

      q = new LinkedList<>();
      q.add(new Knight(start_x, start_y));

      while (!q.isEmpty()) {
        Knight curr = q.poll();

        if (curr.x == target_x && curr.y == target_y) {
          break;
        }

        for (int i = 0; i < 8; i++) {
          int next_x = curr.x + dx[i];
          int next_y = curr.y + dy[i];

          if (0 <= next_x && next_x < N && 0 <= next_y && next_y < N) {
            if (!visit[next_x][next_y]) {
              cnt[next_x][next_y] = cnt[curr.x][curr.y] + 1;
              visit[next_x][next_y] = true;
              q.add(new Knight(next_x, next_y));
            }
          }
        }
      }

      System.out.println(cnt[target_x][target_y]);
    }

  }

}

class Knight {
  int x, y;

  public Knight(int x, int y) {
    this.x = x;
    this.y = y;
  }
}