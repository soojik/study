import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dr = {0, -1, 0, 1};
  static int[] dc = {-1, 0, 1, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int test = Integer.parseInt(br.readLine());

    for (int t = 0; t < test; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int c_len = Integer.parseInt(st.nextToken());
      int r_len = Integer.parseInt(st.nextToken());

      char[][] map = new char[r_len][c_len];

      Queue<Point> q = new LinkedList<>();

      // 불이 번진곳, 번질곳 모두 접근할 수 없으니까 불 먼저 map 에 체크해주기 위해
      // startPoint 는 따로 저장했다가 마지막에 q에 넣어준다.
      Point startPoint = null;
      for (int i = 0; i < r_len; i++) {
        String input_str = br.readLine();
        for (int j = 0; j < c_len; j++) {
          map[i][j] = input_str.charAt(j);
          if (map[i][j] == '*') {
            q.add(new Point(i, j, '*'));
          } else if (map[i][j] == '@') {
            startPoint = new Point(i, j, '@');
          }
        }
      }

      q.add(startPoint);

      boolean[][] visit = new boolean[r_len][c_len];
      int[][] cnt = new int[r_len][c_len];

      visit[startPoint.r][startPoint.c] = true;

      int min = Integer.MAX_VALUE;

      while (!q.isEmpty()) {
        Point curr = q.poll();

        // *이면 사방 map 에 체크 후 q에 추가
        if (curr.type == '*') {
          for (int i = 0; i < 4; i++) {
            int nr = curr.r + dr[i];
            int nc = curr.c + dc[i];

            if (0 <= nr && nr < r_len && 0 <= nc && nc < c_len) {
              // 벽(#)에는 불이 붙을 수 업속
              // 불(*)에는 다시 체크하지 않아도 된다.
              if (map[nr][nc] == '.' || map[nr][nc] == '@') {
                map[nr][nc] = '*';
                q.add(new Point(nr, nc, '*'));
              }
            }
          }
          continue;
        }

        for (int i = 0; i < 4; i++) {
          int nr = curr.r + dr[i];
          int nc = curr.c + dc[i];

          if (0 <= nr && nr < r_len && 0 <= nc && nc < c_len) {
            // 방문하지 않았고, 빈 공간(.)이면 q에 추가
            if (!visit[nr][nc] && map[nr][nc] == '.') {
              // 방문 체크
              visit[nr][nc] = true;
              q.add(new Point(nr, nc, '@'));
              cnt[nr][nc] = cnt[curr.r][curr.c] + 1;
            }
          }
          // 영역을 벗어났다면 탈출 성공이니까 현재 위치까지 왔던 시간에 1초 더해주고 min 업데이트
          else {
            min = Math.min(min, cnt[curr.r][curr.c] + 1);
          }
        }
      }
      System.out.println(min == Integer.MAX_VALUE ? "IMPOSSIBLE" : min);
    }
  }
}

class Point {
  @Override
  public String toString() {
    return "Point{" +
            "r=" + r +
            ", c=" + c +
            ", type=" + type +
            '}';
  }

  int r;
  int c;
  char type;

  public Point(int r, int c, char type) {
    this.r = r;
    this.c = c;
    this.type = type;
  }
}