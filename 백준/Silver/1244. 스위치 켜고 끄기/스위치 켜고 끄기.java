import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[] bulbs;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    bulbs = new int[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      bulbs[i] = Integer.parseInt(st.nextToken());
    }

    int K = Integer.parseInt(br.readLine());

    // 1: 남, 2: 여
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int gender = Integer.parseInt(st.nextToken());
      int idx = Integer.parseInt(st.nextToken());

      if (gender == 1) {
        doBoys(idx);
        continue;
      }
      doGirls(idx);
    }

    StringBuffer sb = new StringBuffer();
    for (int i = 1; i <= N; i++) {
      sb.append(bulbs[i]).append(" ");
      if (i % 20 == 0) sb.append("\n");
    }
    System.out.println(sb);
  }

  static void doBoys(int idx) {
    for (int i = idx; i <= N; i+=idx) {
      bulbs[i] = bulbs[i] == 1 ? 0 : 1;
    }
  }

  static void doGirls(int idx) {
    bulbs[idx] = bulbs[idx] == 1 ? 0 : 1;
    for (int i = 1, p1 = idx + i, p2 = idx - i; idx + i <= N && 1 <= idx - i; i++, --p2, ++p1) {
      if (bulbs[p1] != bulbs[p2]) return;
      bulbs[p1] = bulbs[p1] == 1 ? 0 : 1;
      bulbs[p2] = bulbs[p2] == 1 ? 0 : 1;
    }
  }
}
