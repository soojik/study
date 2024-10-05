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
  static int N, M, START, END;
  static List<List<int[]>> graph = new ArrayList<>();
  static PriorityQueue<int[]> pq = new PriorityQueue<>((int[] arr1, int[] arr2) -> arr1[1] - arr2[1]);
  static boolean[] visited;
  static int[] min;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    visited = new boolean[N + 1];
    min = new int[N + 1];
    Arrays.fill(min, Integer.MAX_VALUE);

    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    StringTokenizer st;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph.get(u).add(new int[]{v, w});
    }

    st = new StringTokenizer(br.readLine());
    START = Integer.parseInt(st.nextToken());
    END = Integer.parseInt(st.nextToken());

    pq.add(new int[]{START, 0});
    min[START] = 0;

    while(!pq.isEmpty()) {
      int[] curr = pq.poll();

      if (visited[curr[0]]) continue;
      visited[curr[0]] = true;

      for (int[] next : graph.get(curr[0])) {
        if (min[curr[0]] + next[1] < min[next[0]]) {
          min[next[0]] = min[curr[0]] + next[1];
          pq.add(new int[]{next[0], min[next[0]]});
        }
      }
    }

    System.out.println(min[END]);
  }
}
