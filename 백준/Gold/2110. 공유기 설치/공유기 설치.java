import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N, C;
  static int[] routers;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    routers = new int[N];

    for (int i = 0; i < N; i++) {
      routers[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(routers);

    int start = 0, end = routers[routers.length - 1];
    int mid = 0;

    while (start <= end) {
      mid = (start + end) / 2;

      if (isValid(mid)) {
        start = mid + 1;
      }
      else {
        end = mid - 1;
      }
    }

    System.out.println(start - 1);
//    System.out.println(end);
//    System.out.println(mid);
  }

  static boolean isValid(int dist) {
//    System.out.println("dist = " + dist);
    int cnt = 1;
    int last_idx = 0;
    int len = routers.length;
    for (int i = 0; i < len; i++) {
      if (dist <= routers[i] - routers[last_idx]) {
        last_idx = i;
        ++cnt;
      }
    }

    return C <= cnt;
  }
}
