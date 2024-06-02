import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int V, E;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    long[][] graph = new long[V + 1][V + 1];

    for (int i = 1; i <= V; i++) {
      Arrays.fill(graph[i], Integer.MAX_VALUE);
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      graph[a][b] = c;
    }

    for (int k = 1; k <= V; k++) {
      for (int i = 1; i <= V; i++) {
        for (int j = 1; j <= V; j++) {
          if (i == j) continue;
          graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
        }
      }
    }

    long ans = Long.MAX_VALUE;
    for (int i = 1; i <= V; i++) {
      for (int j = 1; j <= V; j++) {
        // 양 방향 모두 초기값이 아니라면 사이클로 간주하고 ans 업데이트 
        if (graph[i][j] == Integer.MAX_VALUE || graph[j][i] == Integer.MAX_VALUE) continue;
        ans = Math.min(ans, graph[i][j] + graph[j][i]);
      }
    }

    System.out.println(Integer.MAX_VALUE <= ans ? -1 : ans);
  }
}
