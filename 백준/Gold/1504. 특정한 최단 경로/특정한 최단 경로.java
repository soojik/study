import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static int N, E;
  static List<List<int[]>> graph = new ArrayList<>();
  static PriorityQueue<int[]> pq = new PriorityQueue<>((int[] arr1, int[] arr2) -> arr1[1] - arr2[1]);
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    // 1 -> N
    // 중복 이동 가능
    N = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph.get(u).add(new int[]{v, w});
      graph.get(v).add(new int[]{u, w});
    }

    st = new StringTokenizer(br.readLine());
    int V1 = Integer.parseInt(st.nextToken());
    int V2 = Integer.parseInt(st.nextToken());

    int dist1 = dijkstra(1, V1);
    int dist2 = dijkstra(V2, N);
    int dist3 = dijkstra(V1, V2);
    int dist4 = dijkstra(1, V2);
    int dist5 = dijkstra(V1, N);
    int dist6 = dijkstra(V2, V1);

    int answer = Integer.MAX_VALUE;
    if (dist1 != Integer.MAX_VALUE && dist2 != Integer.MAX_VALUE && dist3 != Integer.MAX_VALUE) {
      answer = dist1 + dist2 + dist3;
    }
    if (dist4 != Integer.MAX_VALUE && dist5 != Integer.MAX_VALUE && dist6 != Integer.MAX_VALUE) {
      answer = Math.min(answer, dist4 + dist5 + dist6);
    }

    System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
  }

  static int dijkstra(int start, int end) {
    int[] dist = new int[N + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    boolean[] visited = new boolean[N + 1];
    pq.add(new int[]{start, 0});
    dist[start] = 0;

    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      visited[curr[0]] = true;

      for (int[] next : graph.get(curr[0])) {
        if (visited[next[0]]) continue;
        if (dist[curr[0]] + next[1] < dist[next[0]]) {
          dist[next[0]] = dist[curr[0]] + next[1];
          pq.add(new int[]{next[0], dist[next[0]]});
        }
      }
    }

    return dist[end];
  }
}
