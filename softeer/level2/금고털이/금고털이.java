import java.io.*;
import java.util.*;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  static int answer = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int W = stoi(st.nextToken());
    int N = stoi(st.nextToken());

    int[][] jewels = new int[N][2];
    for (int i=0;i<N;i++) {
      st = new StringTokenizer(br.readLine());
      jewels[i][0] = stoi(st.nextToken());
      jewels[i][1] = stoi(st.nextToken());
    }

    Arrays.sort(jewels, (int[] j1, int[] j2) -> {
      return j2[1] - j1[1];
    });

    for (int i=0;i<N;i++) {
      if (W <= 0) break;

      answer += ((jewels[i][0] < W) ? jewels[i][0] : W) * jewels[i][1];

      W -= jewels[i][0];
    }

    System.out.println(answer);
  }
}
