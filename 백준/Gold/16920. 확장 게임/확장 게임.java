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
  static Queue<int[]>[] q; // player 마다 직전 라운드에서 정복한 땅 누적
  static int[] max_dist; // 주어지는 한번에 확장할 수 있는 영역(거리)
  static int[] cnt_area; // player 마다 정복한 영역 넓이

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
      for (int i = 0; i < N; i++) {
        String line = br.readLine();
        for (int j = 0; j < M; j++) {
          map[i][j] = line.charAt(j);
          if (Character.isDigit(map[i][j])) {
            // 시작 땅 추가
            ++cnt_area[map[i][j] - '0'];
            // 직전에 확보한 땅에 추가
            q[map[i][j] - '0'].add(new int[]{i, j});
          }
        }
      }

      // player 1 부터 라운드 시작
      int player = 1;
      // 한 라운드에서 각자 정복한 영역의 전체 합으로, 만약 라운드가 끝난 후 값이 0 이라면 게임 끝
      int round = 0;

      while (true) {
        int curr_cnt = 0; // 이번 차례에 확보한 영역 크기
        int dist = max_dist[player]; // 시작점으로부터 확장한 가능한 거리 중 낭은 거리
        while (!q[player].isEmpty()) {

          // 차레대로 1, .., dist 만큼 떨어진 땅을 확보
          int size = q[player].size();

          for (int i = 0; i < size; i++) {

            // 영역 넓힐 기준 땅
            int[] curr = q[player].poll();

            for (int j = 0; j < 4; j++) {
              int nr = curr[0] + dr[j];
              int nc = curr[1] + dc[j];

              if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                // 만약 정복할 수 없는 땅이라면 탐색하지 않음
                if (map[nr][nc] != '.') continue;

                // map 에 정복 표시하고
                map[nr][nc] = (char) (player + '0');
                // 마지막으로 확보한 땅이기 때문에 q에 추가
                q[player].add(new int[]{nr, nc});
                // 현재 라운드에서 확보한 땅의 수 1 증가 
                ++curr_cnt;
              }
            }

          }
          // 더 나아갈 수 있는 거리 1 감소
          --dist;
          // 만약 더이상 나아갈 수 없다면 현재 player 의 라운드 종료
          if (0 == dist) break;

        }

        // player가 현 라운드에서 확보한 땅 추가
        cnt_area[player] += curr_cnt;
        // 현 라운드에서 확보된 땅 수 추가 
        round += curr_cnt;
        // 다음 player에게 차례 넘기기
        ++player;

        // 만약 마지막 player 까지 마쳤다면 
        if (player == P + 1) {
          // 현 라운드에서 확보된 땅이 없다면 영역을 넒힐 수 있는 땅이 없다는 의미니까 게임 종료
          if (round == 0) break;
          // 아니라면 다시 player 1로 돌아가고, 라운드 0으로 초기화 
          player = 1;
          round = 0;
        }
      }

      // 답 출력
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i <= P; i++) {
        sb.append(cnt_area[i]).append(" ");
      }
      System.out.println(sb);
//      br.readLine();
//    }
  }
}