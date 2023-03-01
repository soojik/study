package P1926;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};

  static int N, M;
  static int[][] map;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("BOJ/src/P1926/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    visited = new boolean[N][M];
    int max = 0;
    int cnt = 0;
    // BFS ; 큐를 이용한 넓이 우선 탐색

    int area_cnt = 0;

    Queue<Dot> q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j] && map[i][j] == 1) {
          visited[i][j] = true;
          area_cnt++;

          q.add(new Dot(i, j));

          cnt = 0;

          while (!q.isEmpty()) {
            Dot curr = q.poll();
            cnt++;

            for (int k = 0; k < 4; k++) {
              int next_x = curr.x + dx[k];
              int next_y = curr.y + dy[k];

              if (0 <= next_x && next_x < N && 0 <= next_y && next_y < M) {
                if (!visited[next_x][next_y] && map[next_x][next_y] == 1) {
                  visited[next_x][next_y] = true;
                  q.add(new Dot(next_x, next_y));
                }
              }
            }
          }

          max = Math.max(cnt, max);
        }
      }
    }

    System.out.println(area_cnt);
    System.out.println(max);

  }
}

class Dot {
  int x;
  int y;

  public Dot(int x, int y) {
    this.x = x;
    this.y = y;
  }

}