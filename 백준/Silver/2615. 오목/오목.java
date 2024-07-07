import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] board = new int[19][19];
  static int[] ans = new int[2];
  static int color_ans = 0;
  static int[] dr = {1, 0, 1, -1};
  static int[] dc = {0, 1, 1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    for (int i = 0; i < 19; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 19; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < 19; i++) {
      for (int j = 0; j < 19; j++) {
        if (board[i][j] != 0 && isBingo(i, j, board[i][j])) {
          System.out.println(board[i][j]);
          System.out.println((i + 1) + " " + (j + 1));
          return;
        }
      }
    }

    System.out.println(0);
  }

  static boolean isBingo(int r, int c, int color) {
    for (int dir = 0; dir < 4; dir++) {
      int cnt = 1;
      for (int i = 1; i < 5; i++) {
        int nr = r + dr[dir] * i;
        int nc = c + dc[dir] * i;

        if (!(nr >= 0 && nr < 19 && nc >= 0 && nc < 19) || board[nr][nc] != color) {
          break;
        }
        cnt++;
      }

      if (cnt == 5) {
        int pr = r - dr[dir];
        int pc = c - dc[dir];
        int nr = r + dr[dir] * 5;
        int nc = c + dc[dir] * 5;

        if ((pr >= 0 && pr < 19 && pc >= 0 && pc < 19 && board[pr][pc] == color) ||
                (nr >= 0 && nr < 19 && nc >= 0 && nc < 19 && board[nr][nc] == color)) {
          continue;
        }

        return true;
      }
    }

    return false;
  }
}
