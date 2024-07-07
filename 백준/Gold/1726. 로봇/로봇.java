import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int[][] board;
  static int N, M;
  static int[] dr = {0, 0, 0, 1, -1};
  static int[] dc = {0, 1, -1, 0, 0};
  static int[][][] cnt;
  static int[] start = new int[3];
  static int[] target = new int[3];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new int[N + 1][M + 1];
    cnt = new int[N + 1][M + 1][5];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
    st = new StringTokenizer(br.readLine());
    target = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

    bfs();
  }

  static void bfs() {
    Queue<int[]> q = new LinkedList<>();
    q.add(start);

    while (!q.isEmpty()) {
      int[] curr = q.poll();

      int cr = curr[0], cc = curr[1], cd = curr[2];
      if (board[cr][cc] == 1) return;
      if (cr == target[0] && cc == target[1] && cd == target[2]) {
        System.out.println(cnt[cr][cc][cd]);
        return;
      }
      int nr, nc, nd;
      // 회전
      if (cd <= 2) {
        for (int i = 3; i <= 4; i++) {
          if (cnt[cr][cc][i] == 0) {
            cnt[cr][cc][i] = cnt[cr][cc][cd] + 1;
            q.add(new int[]{cr, cc, i});
          }
        }
      }
      else {
        for (int i = 1; i <= 2; i++) {
          if (cnt[cr][cc][i] == 0) {
            cnt[cr][cc][i] = cnt[cr][cc][cd] + 1;
            q.add(new int[]{cr, cc, i});
          }
        }
      }

      // 이동
      for (int i = 1; i <= 3; i++) {
        nr = cr + dr[cd] * i;
        nc = cc + dc[cd] * i;

        if (1 <= nr && nr <= N && 1 <= nc && nc <= M && board[nr][nc] == 0) {
          if (cnt[nr][nc][cd] == 0) {
            cnt[nr][nc][cd] = cnt[cr][cc][cd] + 1;
            q.add(new int[]{nr, nc, cd});
          }
          continue;
        }
        break;
      }
    }
  }
}
