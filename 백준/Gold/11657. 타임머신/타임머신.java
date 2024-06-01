import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    List<Node> list = new ArrayList<>();
    long[] dist = new long[N + 1];
    Arrays.fill(dist, Long.MAX_VALUE);

    // 출발도시, 도착도시, 걸리는 시간
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      list.add(new Node(s, e, c));
    }

    dist[1] = 0;

    for (int i = 0; i < N; i++) {

      for (int j = 0; j < M; j++) {
        Node curr = list.get(j);
        if (dist[curr.s] != Long.MAX_VALUE && dist[curr.s] + curr.c < dist[curr.e]) {
          dist[curr.e] = dist[curr.s] + curr.c;
        }
      }
    }

    for (int i = 0; i < M; i++) {
      Node curr = list.get(i);

      if (dist[curr.s] != Long.MAX_VALUE && dist[curr.s] + curr.c < dist[curr.e]) {
        System.out.println(-1);
        System.exit(0);
      }
    }

    for (int i = 2; i < N + 1; i++) {
      System.out.println(dist[i] == Long.MAX_VALUE ? -1 : dist[i]);
    }
  }
}

class Node {
  int s;
  int e;
  int c;

  public Node(int s, int e, int c) {
    this.s = s;
    this.e = e;
    this.c = c;
  }
}