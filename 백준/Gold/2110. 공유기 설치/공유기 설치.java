import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N, C;
  static int[] dist;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    dist = new int[N];
    for (int i = 0; i < N; i++) {
      dist[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(dist);

    System.out.println(bs());
  }

  static int bs() {
    int start = 1;
    int end = dist[dist.length - 1];

    while(start <= end) {
      int mid = (start + end) / 2;

      if (valid(mid)) {
        start = mid + 1;
      }
      else {
        end = mid - 1;
      }
    }

    return end;
  }

  static boolean valid(int mid) {
    int visited = 1;
    int last_idx = 0;
    for (int i = 0; i < dist.length; i++) {
      if (mid <= dist[i] - dist[last_idx]) {
        ++visited;
        last_idx = i;
      }
    }

    return C <= visited;
  }
}
