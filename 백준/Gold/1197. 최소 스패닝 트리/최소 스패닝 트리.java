import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static int V, E;
  static PriorityQueue<Node> pq = new PriorityQueue<>();
  static int[] parents;
  static int ans = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    parents = new int[V + 1];
    for (int i = 1; i <= V; i++) {
      parents[i] = i;
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());

      pq.add(new Node(A, B, C));
    }

    while (!pq.isEmpty()) {
      Node curr = pq.poll();

      if (!isConnected(curr.from, curr.to)) {
        ans += curr.cost;
        unionParent(curr.from, curr.to);
      }
    }

    System.out.println(ans);
  }

  static boolean isConnected(int n1, int n2) {
    return getParent(n1) == getParent(n2);
  }

  static int getParent(int n) {
    if (parents[n] == n) return n;
    return parents[n] = getParent(parents[n]);
  }

  static void unionParent(int n1, int n2) {
    n1 = getParent(n1);
    n2 = getParent(n2);

    if (n1 < n2) parents[n2] = n1;
    else parents[n1] = n2;
  }
}

class Node implements Comparable<Node> {
  int from, to, cost;

  public Node(int from, int to, int cost) {
    this.from = from;
    this.to = to;
    this.cost = cost;
  }


  @Override
  public int compareTo(Node o) {
    return this.cost - o.cost;
  }
}