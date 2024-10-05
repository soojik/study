import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int V, E;
  static int start;
  static int[] min;
  static boolean[] visited;
  static List<List<int[]>> graph = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    start = Integer.parseInt(br.readLine());
    min = new int[V + 1];
    visited = new boolean[V + 1];
    Arrays.fill(min, Integer.MAX_VALUE);
    for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph.get(u).add(new int[]{v, w});
    }

    dijkstra();

    StringBuffer sb = new StringBuffer();
    for (int i = 1; i <= V; i++) {
      sb.append(min[i] == Integer.MAX_VALUE ? "INF" : min[i]).append("\n");
    }

    System.out.println(sb);
  }

  static void dijkstra() {
    PriorityQueue<int[]> q = new PriorityQueue<>((int[] i1, int[] i2) -> i1[1] - i2[1]);
    q.add(new int[]{start, 0});
    min[start] = 0;

    while (!q.isEmpty()) {
      int[] curr = q.poll();

      if (visited[curr[0]]) continue;
      visited[curr[0]] = true;

      for (int[] next : graph.get(curr[0])) {
        if (min[curr[0]] + next[1] < min[next[0]]) {
          min[next[0]] = min[curr[0]] + next[1];

          q.add(new int[]{next[0], min[next[0]]});
        }
      }
    }
  }
}
