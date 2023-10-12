import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static boolean[][] map;
  // [x][y]에서 [z]를 추가해 K를 사용한 숫자마다 따로 방문 여부를 체크
  static boolean[][][] visit;
  static int K, W, H;
  // 0~3: 인접한 네방향
  // 4~11: 말로서 이동할 수 있는 칸
  static int[] dr = {0, 1, 0, -1, 2, 2, 1, 1, -1, -1, -2, -2};
  static int[] dc = {-1, 0, 1, 0, -1, 1, -2, 2, -2, 2, -1, 1};
  static int answer = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    K = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    map = new boolean[H][W];

    for (int i = 0; i < H; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < W; j++) {
        // 이동할 수 없는 칸은 false
        map[i][j] = Integer.parseInt(st.nextToken()) == 0;
      }
    }

    visit = new boolean[H][W][K + 1];

    Queue<Point> q = new LinkedList<>();
    q.add(new Point(0, 0, K, 0));
    visit[0][0][0] = true;

    while (!q.isEmpty()) {
      Point curr = q.poll();

      // 최종 목적지 도착하면 중단
      if (curr.r == H - 1 && curr.c == W - 1) {
        System.out.println(curr.cnt);
        return;
      }

      // 네방향으로 한번씩 이동
      int nr, nc;
      for (int i = 0; i < 4; i++) {
        nr = curr.r + dr[i];
        nc = curr.c + dc[i];

        // 맵 범위 안이면서, 방문 하지 않았고 장애물이 없는 구역이면 옆 칸으로 이동
        if (!(0 <= nr && nr < H && 0 <= nc && nc < W) || visit[nr][nc][K - curr.leftK] || !map[nr][nc]) continue;
        visit[nr][nc][K - curr.leftK] = true;
        q.add(new Point(nr, nc, curr.leftK, curr.cnt + 1));
      }

      // K 가 남았을 때
      if (curr.leftK > 0) {
        for (int i = 4; i < 12; i++) {
          nr = curr.r + dr[i];
          nc = curr.c + dc[i];
          // 맵 범위 안이면서, 방문 하지 않았고 장애물이 없는 구역이면 말 이동으로 다른 칸으로 이동
          if (!(0 <= nr && nr < H && 0 <= nc && nc < W) || visit[nr][nc][K - curr.leftK + 1] || !map[nr][nc]) continue;
          visit[nr][nc][K - curr.leftK + 1] = true;
          q.add(new Point(nr, nc, curr.leftK - 1, curr.cnt + 1));
        }
      }
    }

    System.out.println(-1);
  }
}

class Point {
  int r;
  int c;
  int leftK;
  int cnt;

  public Point(int r, int c, int leftK, int cnt) {
    this.r = r;
    this.c = c;
    this.leftK = leftK;
    this.cnt = cnt;
  }
}