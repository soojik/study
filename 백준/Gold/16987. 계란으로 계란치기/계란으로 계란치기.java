import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[][] eggs;
  static int ans = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    eggs = new int[N][2];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st =new StringTokenizer(br.readLine());

      eggs[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
    }

    hitEgg(0, 0);

    System.out.println(ans);

  }

  static void hitEgg(int idx, int cnt) {
    if (idx == N) {
      ans = Math.max(cnt, ans);
      return;
    }

    if (eggs[idx][0] <= 0) {
      hitEgg(idx + 1, cnt);
      return;
    }

    for (int i = 0; i < N; i++) {
      if (idx == i || eggs[idx][0] <= 0 || eggs[i][0] <= 0) continue;
      int origin_1 = eggs[idx][0];
      int origin_2 = eggs[i][0];
      eggs[idx][0] = eggs[idx][0] - eggs[i][1];
      eggs[i][0] = eggs[i][0] - eggs[idx][1];
      int n_cnt = cnt;
      if (eggs[idx][0] <= 0) ++n_cnt;
      if (eggs[i][0] <= 0) ++n_cnt;
      ans = Math.max(ans, n_cnt);
      hitEgg(idx + 1, n_cnt);
      eggs[idx][0] = origin_1;
      eggs[i][0] = origin_2;
    }
  }

  static boolean check() {
    for (int i = 0; i < N; i++) {
      if (eggs[i][0] != 0) return false;
    }

    return true;
  }
}
