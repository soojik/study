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
  static int N, M, X;
  static List<List<int[]>> graph = new ArrayList<>();
  static PriorityQueue<int[]> pq = new PriorityQueue<>((int[] arr1, int[] arr2) -> arr1[1] - arr2[1]);
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph.get(u).add(new int[]{v, w});
    }

    int max = 0;
    for (int i = 1; i <= N; i++) {
      max = Math.max(max, dijkstra(i, X) + dijkstra(X, i));
    }
    System.out.println(max);
  }

  static int dijkstra(int start, int end) {
    int[] min = new int[N + 1];
    Arrays.fill(min, Integer.MAX_VALUE);
    boolean[] visited = new boolean[N + 1];
    pq.add(new int[]{start, 0});
    visited[start] = true;
    min[start] = 0;

    while (!pq.isEmpty()) {
      int[] curr = pq.poll();

      visited[curr[0]] = true;

      for (int[] next : graph.get(curr[0])) {
        if (visited[next[0]]) continue;
        if (min[curr[0]] + next[1] < min[next[0]]) {
          min[next[0]] = min[curr[0]] + next[1];
          pq.add(new int[]{next[0], min[next[0]]});
        }
      }
    }

    return min[end];
  }
}
