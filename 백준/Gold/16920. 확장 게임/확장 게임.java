import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int[] dr = {0, 0, -1, 1};
  static int[] dc = {-1, 1, 0, 0};
  static int N, M, P;
  static char[][] map;
  static Queue<int[]>[] q;
  static int[] max_dist;
  static int[] cnt_area;
  static boolean[][] visit;

  public static void main(String[] args) throws IOException {
//    System.setIn(new FileInputStream("BOJ/src/P16920/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      P = Integer.parseInt(st.nextToken());

//      if (N == 0) return;

      q = new Queue[P + 1];
      max_dist = new int[P + 1];
      cnt_area = new int[P + 1];
      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= P; i++) {
        max_dist[i] = Integer.parseInt(st.nextToken());
        q[i] = new LinkedList<>();
      }

      map = new char[N][M];
      visit = new boolean[N][M];
      for (int i = 0; i < N; i++) {
        String line = br.readLine();
        for (int j = 0; j < M; j++) {
          map[i][j] = line.charAt(j);
          if (Character.isDigit(map[i][j])) {
            ++cnt_area[map[i][j] - '0'];
            q[map[i][j] - '0'].add(new int[]{i, j});
          }
        }
      }

      int player = 1;
      int round = 0;

      while (true) {
        int curr_cnt = 0; // 이번 차례에 확보한 영역 크기
        int dist = max_dist[player]; // 시작점으로부터 확장한 가능한 거리 중 낭은 거리
        while (!q[player].isEmpty()) {

          int size = q[player].size();

          for (int i = 0; i < size; i++) {

            int[] curr = q[player].poll();

            for (int j = 0; j < 4; j++) {
              int nr = curr[0] + dr[j];
              int nc = curr[1] + dc[j];

              if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                if (map[nr][nc] != '.') continue;

                map[nr][nc] = (char) (player + '0');
                q[player].add(new int[]{nr, nc});
                ++curr_cnt;
              }
            }

          }
          --dist;
          if (0 == dist) break;

        }

        cnt_area[player] += curr_cnt;
        round += curr_cnt;
        ++player;

        if (player == P + 1) {
          if (round == 0) break;
          player = 1;
          round = 0;
        }
      }

      StringBuilder sb = new StringBuilder();
      for (int i = 1; i <= P; i++) {
        sb.append(cnt_area[i]).append(" ");
      }
      System.out.println(sb);
//      br.readLine();
//    }
  }
}