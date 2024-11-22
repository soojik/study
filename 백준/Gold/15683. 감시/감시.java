import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static char[][] map;
  static int[][] cnt;
  static List<int[]> cameras = new ArrayList<>();
  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};
  static int total = 0;
  static int answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    answer = N * M;

    map = new char[N][M];
    cnt = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = st.nextToken().charAt(0);
        if (Character.isDigit(map[i][j]) && 1 <= map[i][j] - '0' && map[i][j] - '0' <= 5) {
          cameras.add(new int[]{i, j, map[i][j] - '0'});
        }
      }
    }

    func(0);

    System.out.println(answer);
  }

  static void func(int depth) {
    if (depth == cameras.size()) {
      answer = Math.min(answer, get_answer());
      return;
    }

    int[] camera = cameras.get(depth);
    int r = camera[0];
    int c = camera[1];
    int type = camera[2];

    for (int d = 0; d < get_direction_cnt(type); d++) {
      check(r, c, type, d, 1);
      func(depth + 1);
      check(r, c, type, d, -1);
    }
  }

  static int get_direction_cnt(int type) {
    switch (type) {
        /*
        0, 1
        1, 0
        2, 3
        3, 2
         */
      case 2: return 2;
      case 5: return 1;
      default: return 4;
    }
  }

  static void check(int r, int c, int type, int dir, int flag) {
    int[][] directions = getCameraDirections(type, dir);

    for (int[] d : directions) {
      int nr = r, nc = c;
      while (true) {
        nr += d[0];
        nc += d[1];
        if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '6') break;
        if (map[nr][nc] == '0') cnt[nr][nc] += flag;
      }
    }
  }

  static int[][] getCameraDirections(int type, int dir) {
    switch (type) {
      case 1:
        return new int[][]{{dr[dir], dc[dir]}};
      case 2:
        return new int[][]{{dr[dir * 2], dc[dir * 2]}, {dr[dir * 2 + 1], dc[dir * 2 + 1]}};
      case 3:
        int[] origin = {dr[dir], dc[dir]};
        int[] another = {0, 0};
        /* 기준 방향 (dir) 의 왼쪽
        dir, 왼쪽
        0, 2
        1, 3
        2, 1
        3, 0
         */
        if (dir == 0) {
          another = new int[]{dr[2], dc[2]};
        }
        if (dir == 1) {
          another = new int[]{dr[3], dc[3]};
        }
        if (dir == 2) {
          another = new int[]{dr[1], dc[1]};
        }
        if (dir == 3) {
          another = new int[]{dr[0], dc[0]};
        }
        return new int[][]{origin, another};
      case 4:
        return new int[][]{{dr[dir], dc[dir]}, {dr[(dir + 1) % 4], dc[(dir + 1) % 4]}, {dr[(dir + 3) % 4], dc[(dir + 3) % 4]}};
      case 5:
        return new int[][]{{dr[0], dc[0]}, {dr[1], dc[1]}, {dr[2], dc[2]}, {dr[3], dc[3]}};
      default:
        return new int[0][0];
    }
  }

  static int get_answer() {
    int result = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == '0' && cnt[i][j] == 0) {
          result++;
        }
      }
    }

    return result;
  }
}
