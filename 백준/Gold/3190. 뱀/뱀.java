import java.awt.desktop.QuitEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static boolean[][] apple_map;
  static int last_dir = 0;
  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};
  static int answer = 0;
  static Deque<int[]> snake = new ArrayDeque<>();
  static Queue<int[]> next = new LinkedList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    apple_map = new boolean[N + 1][N + 1];
    int test = Integer.parseInt(br.readLine());
    while (test-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      apple_map[r][c] = true;
    }

    snake.addLast(new int[]{1, 1});
    test = Integer.parseInt(br.readLine());
    while (test-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int time = Integer.parseInt(st.nextToken());
      int dir = st.nextToken().charAt(0) == 'L' ? -1 : 1;

      next.add(new int[]{time, dir});
    }

    move();

    System.out.println(answer);
  }

  // 왼쪽은 -1 오른쪽은 1
  static void move() {
    while (!snake.isEmpty()) {
      ++answer;
      int nr = snake.peekFirst()[0], nc = snake.peekFirst()[1];
      nr += dr[last_dir];
      nc += dc[last_dir];
      // System.out.println(nr + " " + nc);

      if (1 > nr || nr > N || 1 > nc || nc > N) return;

      for (int[] s : snake) {
        if (s[0] == nr && s[1] == nc) {
          return;
        }
      }

      if (!apple_map[nr][nc]) {
        snake.removeLast();
      } else apple_map[nr][nc] = false;

      snake.addFirst(new int[]{nr, nc});

      if (!next.isEmpty() && next.peek()[0] == answer) {
        last_dir = (last_dir + next.peek()[1] + 4) % 4;
        next.poll();
      }
    }
  }
}
