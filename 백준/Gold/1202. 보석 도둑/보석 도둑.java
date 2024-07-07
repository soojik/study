import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int N, K;
  static int[][] jewels;
  static int[] bags;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    // {무게, 가격}
    PriorityQueue<int[]> pq = new PriorityQueue<>((j1, j2) -> j2[1] == j1[1] ? j1[0] - j2[0] : j2[1] - j1[1]);

    jewels = new int[N][2];
    bags = new int[K];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      jewels[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
    }

    for (int i = 0; i < K; i++) {
      bags[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(jewels, (j1, j2) -> j1[0] - j2[0]);
    Arrays.sort(bags);

    long ans = 0;
    int idx = 0;
    for (int i = 0; i < K; i++) {
      while (idx < N && jewels[idx][0] <= bags[i]) {
        pq.add(jewels[idx]);
        ++idx;
      }
      if (!pq.isEmpty()) ans += pq.poll()[1];
    }

    System.out.println(ans);
  }
}
