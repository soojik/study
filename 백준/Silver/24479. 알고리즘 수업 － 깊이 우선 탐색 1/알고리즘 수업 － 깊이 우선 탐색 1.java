import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int N, M, K;
  static List<List<Integer>> nodes = new ArrayList<>();
  static int cnt = 0;
  static int[] ans;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    ans = new int[N + 1];

    for (int i = 0; i <= N; i++) nodes.add(new ArrayList<>());

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      nodes.get(a).add(b);
      nodes.get(b).add(a);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(nodes.get(i));
    }

    dfs(K);

    StringBuffer sb = new StringBuffer();
    for (int i = 1; i <= N; i++) {
      sb.append(ans[i]).append("\n");
    }
    System.out.println(sb);
  }

  static void dfs(int idx) {
    ans[idx] = ++cnt;
    for (int n : nodes.get(idx)) {
      if (ans[n] != 0) continue;
      dfs(n);
    }
  }
}
