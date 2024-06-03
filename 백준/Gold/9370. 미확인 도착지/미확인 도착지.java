import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int N, M, T, S, G, H;
  static List<Node>[] graph;
  static long[] dist;
  static List<Integer> candidates;
  static List<Integer> ans;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int test = Integer.parseInt(br.readLine());

    StringTokenizer st;
    StringBuffer sb = new StringBuffer();

    for (int t = 0; t < test; t++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      T = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      S = Integer.parseInt(st.nextToken()); // 출발지
      G = Integer.parseInt(st.nextToken()); // 꼭 지나는 간선의 노드 1
      H = Integer.parseInt(st.nextToken()); // 꼭 지나는 간선의 노드 2

      graph = new List[N + 1];
      candidates = new ArrayList<>();
      ans = new ArrayList<>();
      for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

      // M개의 간선
      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        graph[a].add(new Node(b, d));
        graph[b].add(new Node(a, d));
      }

      // 목적지 후보 T개
      for (int i = 0; i < T; i++) {
        candidates.add(Integer.parseInt(br.readLine()));
      }

      for (int target : candidates) {
        long result1 = dijkstra(S, G) + dijkstra(G, H) + dijkstra(H, target);
        long result2 = dijkstra(S, H) + dijkstra(H, G) + dijkstra(G, target);
        long result_total = dijkstra(S, target);
        if (result1 >= Integer.MAX_VALUE || result2 >= Integer.MAX_VALUE) continue;
        if (result1 == result_total || result2 == result_total) ans.add(target);
      }

      Collections.sort(ans);
      for (int i : ans) sb.append(i).append(" ");
      sb.append("\n");
    }

    System.out.println(sb);
  }

  static long dijkstra(int start, int end) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    dist = new long[N + 1];
    Arrays.fill(dist, Long.MAX_VALUE);

    pq.add(new Node(start, 0));
    dist[start] = 0;

    while (!pq.isEmpty()) {
      Node curr = pq.poll();
      if (curr.getCost() > dist[curr.getIdx()]) continue;

      for (Node next : graph[curr.getIdx()]) {
        if (dist[curr.getIdx()] + next.getCost() < dist[next.getIdx()]) {
          dist[next.getIdx()] = dist[curr.getIdx()] + next.getCost();
          pq.add(new Node(next.getIdx(), dist[next.getIdx()]));
        }
      }
    }

    return dist[end];
  }
}

class Node implements Comparable<Node> {
  private int idx;
  private long cost;

  public Node(int idx, long cost) {
    this.idx = idx;
    this.cost = cost;
  }

  public int getIdx() {
    return idx;
  }

  public long getCost() {
    return cost;
  }

  @Override
  public int compareTo(Node o) {
    return Long.compare(this.cost, o.cost);
  }
}
