import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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

    // 갈 수 있는 곳(0), 갈 수 없는 곳(1) 기록
    int[][] map = new int[N + 1][M + 1];
    // cnt[i][j][k] 에 들어갈 값은 거기까지 갈 때 걸리는 시간
    // i,j 는 위치, k는 뚫을 수 있는 벽
    int[][][] cnt = new int[N + 1][M + 1][K + 1];
    // 위와 마찬가지로 한 번 해봤던 위치라면(위치, 뚫을 수 있는 벽) 탐색 하지 않도록 방문 체크
    boolean[][][] visit = new boolean[N + 1][M + 1][K + 1];

    for (int i = 1; i <= N; i++) {
      String input_line = br.readLine();
      for (int j = 1; j <= M; j++) {
        map[i][j] = input_line.charAt(j-1) - '0';
      }
    }

    Queue<Info> q = new LinkedList<>();
    q.add(new Info(1, 1, K));

    // 가장 짧게 걸릴 시간
    int min = Integer.MAX_VALUE;
    while (!q.isEmpty()) {
      Info curr = q.poll();

      // 도착지라면 min 갱신
      if (curr.r == N && curr.c == M) {
        min = Math.min(cnt[curr.r][curr.c][curr.left], min);
        continue;
      }

      int nr, nc;
      for (int i = 0; i < 4; i++) {
        nr = curr.r + dr[i];
        nc = curr.c + dc[i];

        // 범위 안이면서
        if (1 <= nr && nr <= N && 1 <= nc && nc <= M) {
          // 벽을 뚫지 않고 갈 수 있고 아직 방문 안했다면
          if (map[nr][nc] == 0 && !visit[nr][nc][curr.left]) {
            // 현재 cnt 갱신
            cnt[nr][nc][curr.left] = cnt[curr.r][curr.c][curr.left] + 1;
            // 탐색 할 지점으로 추가
            q.add(new Info(nr, nc, curr.left));
            // 다른 경우에서 또 체크 안되도록 미리 방문 체크
            visit[nr][nc][curr.left] = true;
          }
          // 앞이 벽이면서 뚫을 수 있는 벽이 남아있고, 아직 해당 경우는 탐색(방문)하지 않았다면 
          if (curr.left > 0 && map[nr][nc] == 1 && !visit[nr][nc][curr.left - 1]) {
            cnt[nr][nc][curr.left - 1] = cnt[curr.r][curr.c][curr.left] + 1;
            q.add(new Info(nr, nc, curr.left - 1));
            visit[nr][nc][curr.left - 1] = true;
          }
        }

      }
    }
    
    System.out.println(min == Integer.MAX_VALUE ? -1 : min + 1);
  }
}

class Info {
  // 위치(r, c)와 뚫을 수 있는 벽 갯수
  int r, c, left;

  public Info(int r, int c, int left) {
    this.r = r;
    this.c = c;
    this.left = left;
  }
}