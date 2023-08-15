import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  // 각 면, 행, 열을 이동할 순서 (서, 남, 동, 북, 하, 상)
  static int[] dl = {0, 0, 0, 0, -1, 1};
  static int[] dr = {0, -1, 0, 1, 0, 0};
  static int[] dc = {-1, 0, 1, 0, 0, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    while (true) {
      st = new StringTokenizer(br.readLine());

      // 각 L, R, C는 1이상 30 이하
      int L = Integer.parseInt(st.nextToken());
      int R = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());

      // 합이 0이면 모두 0이라는 뜻이므로 프로그램 중단
      if (L + R + C == 0) {
        return;
      }

      // map: 빌딩 맵 정보로, 벽(#), 빈공간(.), 시작점(S), 출구(E)로 이루어져 있다.
      // cnt: 시작점으로부터 {l, r, c}까지 오기까지 걸린 시간을 저장
      // visit: 방문 체크
      char[][][] map = new char[L][R][C];
      int[][][] cnt = new int[L][R][C];
      boolean[][][] visit = new boolean[L][R][C];

      Queue<Point> q = new LinkedList<>();

      for (int i = 0; i < L; i++) {
        for (int j = 0; j < R; j++) {
          String input_str = br.readLine();
          for (int k = 0; k < C; k++) {
            map[i][j][k] = input_str.charAt(k);
            // 시작점은 미리 q에 넣어주기
            if (map[i][j][k] == 'S') {
              q.add(new Point(i, j, k));
              visit[i][j][k] = true;
            }
          }
        }
        br.readLine();
      }

      // 최단 시간
      int min = Integer.MAX_VALUE;

      while (!q.isEmpty()) {
        Point curr = q.poll();

        // 6방향 순회
        for (int i = 0; i < 6; i++) {
          // 다음 공간 {nl, nr, nc} 이
          int nl = curr.l + dl[i];
          int nr = curr.r + dr[i];
          int nc = curr.c + dc[i];

          // 영역 안이면서
          if (0 <= nl && nl < L && 0 <= nr && nr < R && 0 <= nc && nc < C) {
            // 방문하지 않고 빈공간이라 이동할 수 있다면
            if (!visit[nl][nr][nc] && map[nl][nr][nc] == '.') {
              // 미리 방문 체크 후
              visit[nl][nr][nc] = true;
              // 탐색하기 위해 q에 넣어주고
              q.add(new Point(nl, nr, nc));
              // 현재 위치까지 걸린 시간에 1을 더한 값을 다음 위치 cnt 배열에 넣어준다.
              cnt[nl][nr][nc] = cnt[curr.l][curr.r][curr.c] + 1;
            }
            // 출구라면
            else if (map[nl][nr][nc] == 'E') {
              // 최단시간 (min) 갱신
              min = Math.min(min, cnt[curr.l][curr.r][curr.c] + 1);
            }
          }
        }
      }

      // min 값에 따라 결과 출력
      System.out.println(min == Integer.MAX_VALUE ? "Trapped!" : "Escaped in " + min + " minute(s).");
    }

  }
}

/*
Point 클래스는 현재 위치 데이터로,
속성으로 면, 행, 열 값을 갖는다.
 */
class Point {
  int l;
  int r;
  int c;

  public Point(int l, int r, int c) {
    this.l = l;
    this.r = r;
    this.c = c;
  }
}