import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static List<List<int[]>> graph = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph.get(u).add(new int[]{v, w});
      graph.get(v).add(new int[]{u, w});
    }

    for (List<int[]> list : graph) {
      list.sort((a, b) -> a[1] - b[1]);
    }

    System.out.println(dijkstra());
  }

  static int dijkstra() {
    Queue<int[]> q = new LinkedList<>();
    int[] dist = new int[N + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[1] = 0;
    q.add(new int[]{1, 0});

    while (!q.isEmpty()) {
      int[] curr = q.poll();

      for (int[] next : graph.get(curr[0])) {
        if (dist[curr[0]] + next[1] < dist[next[0]]) {
          dist[next[0]] = dist[curr[0]] + next[1];
          q.add(new int[]{next[0], dist[next[0]]});
        }
      }
    }

    return dist[N];
  }
}
