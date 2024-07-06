import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static boolean[][] gear = new boolean[5][8];
  static int[] idx_arr = new int[5];
  static int idx_gear, dir;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    for (int i = 1; i <= 4; i++) {
      String input_str = br.readLine();
      for (int j = 0; j < 8; j++) {
        gear[i][j] = input_str.charAt(j) - '0' == 1;
      }
    }

    int K = Integer.parseInt(br.readLine());
    while (K-- > 0) {
      st = new StringTokenizer(br.readLine());
      idx_gear = Integer.parseInt(st.nextToken());
      dir = Integer.parseInt(st.nextToken());

      rotateGear(idx_gear, dir);
    }

    int ans = 0;
    for (int i = 1; i <= 4; i++) {
      ans += (gear[i][idx_arr[i]] ? 1 : 0) * Math.pow(2, i-1);
    }
    System.out.println(ans);
  }

  static void rotateGear(int start_gear, int dir) {
    // 각 톱니바퀴의 회전 방향
    int[] rotate_dir = new int[5];
    rotate_dir[start_gear] = dir;

    // 시작 바퀴부터 왼쪽 바퀴 검사
    for (int left = start_gear - 1; left >= 1; left--) {
      // 비교 대상(왼쪽) 바퀴의 3시 방향과 이전 바퀴의 6시 방향 톱니를 비교
      if (gear[left][(idx_arr[left] + 2) % 8] == gear[left + 1][(idx_arr[left + 1] + 6) % 8]) {
        break;
      }
      rotate_dir[left] = -rotate_dir[left + 1];
    }

    // 시작 바퀴부터 오른쪽 바퀴 검사
    for (int right = start_gear + 1; right <= 4; right++) {
      // 비교 대상(오른쪽) 바퀴의 9시 방향과 이전 바퀴의 3시 방향 톱니를 비교
      if (gear[right][(idx_arr[right] + 6) % 8] == gear[right - 1][(idx_arr[right - 1] + 2) % 8]) {
        break;
      }
      rotate_dir[right] = -rotate_dir[right - 1];
    }

    for (int i = 1; i <= 4; i++) {
      idx_arr[i] = (idx_arr[i] - rotate_dir[i] + 8) % 8;
    }
  }
}
