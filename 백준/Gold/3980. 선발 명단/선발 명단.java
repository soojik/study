import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] stats = new int[11][11];
  static int ans;
  static boolean[] checked = new boolean[11];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    StringTokenizer st;
    while (T-- > 0) {
      stats = new int[11][11];
      ans = 0;

      for (int i = 0; i < 11; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 11; j++) {
          stats[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      BT(0, 0);

      System.out.println(ans);
    }
  }

  static void BT(int idx, int sum) {
    if (idx == 11) {
      ans = Math.max(ans, sum);
      return;
    }

    for (int i = 0; i < 11; i++) {
      if (stats[idx][i] == 0 || checked[i]) continue;
      checked[i] = true;
      BT(idx + 1, sum + stats[idx][i]);
      checked[i] = false;
    }
  }
}
