import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}

  static int[] dr = {1, 0};
  static int[] dc = {0, 1};

  static int N;
  static int[][] board;
  static long[][] cnt;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = stoi(br.readLine());

    board = new int[N][N];
    cnt = new long[N][N];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        board[i][j] = stoi(st.nextToken());
      }
    }

    cnt[0][0] = 1;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < 2; k++) {
          // 이동할 칸 수
          int move = board[i][j];
          // 0이면 도착지니까 현위치에서 멈추기
          if (move == 0) continue;
          // 다음 위치
          int nr = i + dr[k] * move;
          int nc = j + dc[k] * move;

          // 범위 안이라면
          if (0 <= nr && nr < N && 0 <= nc && nc < N) {
            // 다음 경로에 현재 경우의 수 더해주기
            cnt[nr][nc] += cnt[i][j];
          }
        }
      }
    }

    System.out.println(cnt[N-1][N-1]);
  }
}
