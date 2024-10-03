import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, 1, 0, -1};

  static int N, M;
  static char[][] map;
  static boolean[][] visited;
  static int answer = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new char[N][M];
    for (int i = 0; i < N; i++) {
      String input_str = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = input_str.charAt(j);
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 'L') {
          bfs(i, j);
        }
      }
    }

    System.out.println(answer);
  }

  static void bfs(int r, int c) {
    Queue<Info> q = new LinkedList<>();
    q.add(new Info(r, c, 0));
    visited = new boolean[N][M];
    visited[r][c] = true;

    while (!q.isEmpty()) {
      Info curr = q.poll();
      answer = Math.max(answer, curr.depth);
      int nr, nc;
      for (int i = 0; i < 4; i++) {
        nr = curr.r + dr[i];
        nc = curr.c + dc[i];

        if (0 <= nr && nr < N && 0 <= nc && nc < M) {
          if (visited[nr][nc] || map[nr][nc] == 'W') continue;
          visited[nr][nc] = true;
          q.add(new Info(nr, nc, curr.depth + 1));
        }
      }
    }
  }
}

class Info {
  int r, c, depth;

  public Info(int r, int c, int depth) {
    this.r = r;
    this.c = c;
    this.depth = depth;
  }
}