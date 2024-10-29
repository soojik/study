import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static boolean[][] connected;
  static boolean[] visited;
  static int[] targets;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    connected = new boolean[N + 1][N + 1];
    visited = new boolean[N + 1];
    targets = new int[M];
    StringTokenizer st;
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        connected[i][j] = Integer.parseInt(st.nextToken()) == 1;
      }
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      targets[i] = Integer.parseInt(st.nextToken());
    }

    bfs();
    for (int t : targets) {
      if (!visited[t]) {
        System.out.println("NO");
        return;
      }
    }

    System.out.println("YES");
  }

  static void bfs() {
    Queue<Integer> q = new LinkedList<>();
    q.add(targets[0]);
    visited[targets[0]] = true;

    while (!q.isEmpty()) {
      int curr = q.poll();
      for (int i = 1; i <= N; i++) {
        if (visited[i] || !connected[curr][i]) continue;
        visited[i] = true;
        q.add(i);
      }
    }
  }
}
