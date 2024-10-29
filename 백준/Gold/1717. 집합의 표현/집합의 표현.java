import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[] parent;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    parent = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    int cmd, nodeA, nodeB;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      cmd = Integer.parseInt(st.nextToken());
      nodeA = Integer.parseInt(st.nextToken());
      nodeB = Integer.parseInt(st.nextToken());

      if (cmd == 0) {
        union(nodeA, nodeB);
      }
      else {
        if (find(nodeA) == find(nodeB)) {
          System.out.println("YES");
          continue;
        }
        System.out.println("NO");
      }
    }
  }

  static int find(int node) {
    if (parent[node] == node) {
      return node;
    }
    return parent[node] = find(parent[node]);
  }

  static void union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a != b) {
      parent[b] = a;
    }
  }
}
