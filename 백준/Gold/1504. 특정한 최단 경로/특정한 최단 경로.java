import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int N, E;
  static List<Node>[] graph;
  static int v1, v2;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    graph = new List[N + 1];

    for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      graph[a].add(new Node(b, c));
      graph[b].add(new Node(a, c));
    }

    st = new StringTokenizer(br.readLine());
    v1 = Integer.parseInt(st.nextToken());
    v2 = Integer.parseInt(st.nextToken());

    int[] result = new int[6];
    result[0] = Dijkstra(1, v1);
    result[1] = Dijkstra(v1, v2);
    result[2] = Dijkstra(v2, N);
    result[3] = Dijkstra(1, v2);
    result[4] = Dijkstra(v2, v1);
    result[5] = Dijkstra(v1, N);

    long min1 = 0;
    for (int i = 0; i < 3; i++) {
      if (result[i] == Integer.MAX_VALUE) {
        min1 = Integer.MAX_VALUE;
        break;
      }
      min1 += result[i];
    }

    long min2 = 0;
    for (int i = 3; i < 6; i++) {
      if (result[i] == Integer.MAX_VALUE) {
        min2 = Integer.MAX_VALUE;
        break;
      }
      min2 += result[i];
    }

    long ans = Math.min(min1, min2);
    System.out.println(Integer.MAX_VALUE <= ans ? -1 : ans);
  }

  static int Dijkstra(int start, int end) {
    int[] min_dist = new int[N + 1];
    Arrays.fill(min_dist, Integer.MAX_VALUE);

    PriorityQueue<Node> pq = new PriorityQueue<>();

    pq.add(new Node(start, 0)); // 시작점 1
    min_dist[start] = 0;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      for (Node next : graph[cur.getIdx()]) {
        if (min_dist[cur.getIdx()] + next.getCost() <= min_dist[next.getIdx()]) {
          min_dist[next.getIdx()] = min_dist[cur.getIdx()] + next.getCost();

          pq.add(new Node(next.getIdx(), min_dist[next.getIdx()]));
        }
      }
    }
    return min_dist[end];
  }
}

class Node implements Comparable<Node> {
  private int idx;
  private int cost;

  public Node(int idx, int cost) {
    this.idx = idx;
    this.cost = cost;
  }

  public int getIdx() {
    return idx;
  }

  public int getCost() {
    return cost;
  }

  @Override
  public int compareTo(Node o) {
    return this.cost - o.cost;
  }
}