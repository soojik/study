import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static boolean[][] map;
  static boolean[][][] visit;
  static Queue<Point> q = new LinkedList<>();
  static int[] dr = {0, -1, 0, 1};
  static int[] dc = {-1, 0, 1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new boolean[N][M];
    // 방문 배열을 3차원 배열로 만들어, 벽을 뚫기 전({r, c, 0}), 뚫은 후({r, c, 1}) 의 경우를 나누어 방문 체크를 진행한다.
    visit = new boolean[N][M][2];

    // 이동할 수 있는 부분은 true 로 표시해준다.
    for (int i = 0; i < N; i++) {
      String input_str = br.readLine();
      for (int j = 0; j < M; j++) {
        if (input_str.charAt(j) == '0') map[i][j] = true;
      }
    }

    // 시작점에 방문 체크
    visit[0][0][0] = true;
    visit[0][0][1] = true;
    q.add(new Point(0, 0, 0, 1));

    while (!q.isEmpty()) {
      Point curr = q.poll();

      // 종료지점 다왔으면 answer 와 현재 지나온 경로의 칸 수를 비교해 작은 값으로 업데이트
      if (curr.r == N - 1 && curr.c == M - 1) {
        System.out.println(curr.cnt);
        return;
      }

      // 사방향으로 탐색
      int nr, nc;
      for (int i = 0; i < 4; i++) {
        nr = curr.r + dr[i];
        nc = curr.c + dc[i];

        // 범위 안
        if (0 <= nr && nr < N && 0 <= nc && nc < M) {
          // 아직 방문하지 않은 지점이면서
          if (!visit[nr][nc][curr.isBroken]) {
            // 갈 수 있으면 탐색 진행
            if (map[nr][nc]) {
              visit[nr][nc][curr.isBroken] = true;
              q.add(new Point(nr, nc, curr.isBroken, curr.cnt + 1));
            }
            // 만약 갈 수 없고, 벽을 뚤은 적 없다면
            else if (!map[nr][nc] && curr.isBroken == 0) {
              visit[nr][nc][curr.isBroken] = true;
              // 뚫고 지나가기
              q.add(new Point(nr, nc, 1, curr.cnt + 1));
            }
          }
        }
      }
    }
    
    // 앞 탐색에서 답을 출력하지 못했다면 최단거리 찾지 못했단 말이니까 -1 출력
    System.out.println(-1);
  }
}

class Point {
  int r;
  int c;
  int isBroken;
  int cnt;

  public Point(int r, int c, int isBroken, int cnt) {
    this.r = r;
    this.c = c;
    this.isBroken = isBroken;
    this.cnt = cnt;
  }
}