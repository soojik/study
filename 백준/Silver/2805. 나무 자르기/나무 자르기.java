import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static long[] woods;
  static long max = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    woods = new long[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      woods[i] = Integer.parseInt(st.nextToken());
      max = Math.max(max, woods[i]);
    }

    System.out.println(BS());
  }

  static long BS() {
    long start = 1;
    long end = max;

    long mid;
    while (start < end) {
      mid = (start + end) / 2;

      long sum = getSum(mid);
      if (M <= sum) {
        start = mid + 1;
      }
      else {
        end = mid;
      }
    }

    return start - 1;
  }

  static long getSum(long mid) {
    long result = 0;
    for (long w : woods) {
      result += Math.max(0, w - mid);
    }

    return result;
  }
}
