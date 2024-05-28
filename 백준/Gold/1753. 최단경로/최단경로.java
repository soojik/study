import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int V, E, K;
  static int[] dist;
  static boolean[] visit;
  static List<Node>[] graph;
  static PriorityQueue<Node> pq = new PriorityQueue<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    V = Integer.parseInt(st.nextToken()); // 노드 개수
    E = Integer.parseInt(st.nextToken()); // 간선 개수
    K = Integer.parseInt(br.readLine()); // 출발지

    graph = new List[V + 1];
    for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();
    dist = new int[V + 1];
    visit = new boolean[V + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken()); // 출발지
      int v = Integer.parseInt(st.nextToken()); // 도착지
      int w = Integer.parseInt(st.nextToken()); // 가중치

      graph[u].add(new Node(v, w));
    }

    Dijkstra();

    StringBuffer sb = new StringBuffer();
    for (int i = 1; i <= V; i++) {
      sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
    }

    System.out.println(sb);
  }

  static void Dijkstra() {
    // 시작점

    dist[K] = 0;
    pq.add(new Node(K, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (visit[cur.num]) continue;
      visit[cur.num] = true;

      for (Node n : graph[cur.num]) {
        if (dist[cur.num] + n.cost < dist[n.num]) {
          dist[n.num] = Math.min(dist[cur.num] + n.cost, dist[n.num]);

          pq.add(new Node(n.num, dist[n.num]));
        }
      }
    }
  }
}

class Node implements Comparable<Node> {

  int num;
  int cost;

  public Node(int num, int cost) {
    this.num = num;
    this.cost = cost;
  }

  @Override
  public int compareTo(Node o) {
    return this.cost - o.cost;
  }
}
