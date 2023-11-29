import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, -1, 0, 1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N, M, K;

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = stoi(st.nextToken());
    M = stoi(st.nextToken());
    K = stoi(st.nextToken());

    boolean[][] map = new boolean[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      String input_str = br.readLine();
      for (int j = 1; j <= M; j++) {
        map[i][j] = (input_str.charAt(j - 1) == '0');
      }
    }

    boolean[][][] visit = new boolean[N + 1][M + 1][K + 1];

    Queue<Info> q = new ArrayDeque<>();
    q.add(new Info(1, 1, K, 1, 1));

    while (!q.isEmpty()) {
      Info curr = q.poll();

      if (curr.r == N && curr.c == M) {
        System.out.println(curr.cnt);
        return;
      }

      // 다음 이동 정보
      int nr, nc; // 위치
      int nIsDay = curr.isDay == 0 ? 1 : 0; // 지금이 낮이면 다음 이동 시간은 밤, 밤이면 낮

      for (int i = 0; i < 4; i++) {
        nr = curr.r + dr[i];
        nc = curr.c + dc[i];

        // 범위 벗어나면 탐색 중단
        if (!(1 <= nr && nr <= N && 1 <= nc && nc <= M)) continue;

        // 벽이 없다면
        if (map[nr][nc]) {
          // 다음 이동 정보에 이미 한번 탐색했다면 넘어가기
          if (visit[nr][nc][curr.left]) continue;
          // 방문 체크
          visit[nr][nc][curr.left] = true;
          // 탐색 큐에 추가
          q.add(new Info(nr, nc, curr.left, nIsDay, curr.cnt + 1));
        }
        else {
          // 다음이 벽인데 지금이 밤이라면
          if (curr.isDay == 0) {
            // 이동 시간(isDay) 값만 변경후 탐색 큐에 넣음
            q.add(new Info(curr.r, curr.c, curr.left, nIsDay, curr.cnt + 1));
            // 밑은 벽을 깰 경우니까 진행하지 않음
            continue;
          }
          // 벽을 깰 수 없거나, 이미 방문했다면 탐색 진행하지 않음
          if (curr.left == 0 || visit[nr][nc][curr.left-1]) continue;
          // 벽 하나 꺴으니까 curr.left - 1, 그 외에는 위와 동일
          visit[nr][nc][curr.left-1] = true;
          q.add(new Info(nr, nc, curr.left - 1, nIsDay, curr.cnt + 1));
        }
      }

    }

    // 결과 못찾았다면 -1 출력
    System.out.println(-1);
  }
}

class Info {
  int r, c, left, isDay, cnt;

  public Info(int r, int c, int left, int isDay, int cnt) {
    this.r = r;
    this.c = c;
    this.left = left;
    this.isDay = isDay;
    this.cnt = cnt;
  }
}