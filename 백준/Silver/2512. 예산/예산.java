import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int[] requests;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    requests = new int[N];

    int max = 0;
    int sum = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      requests[i] = Integer.parseInt(st.nextToken());
      sum += requests[i];
      max = Math.max(max, requests[i]);
    }

    Arrays.sort(requests);

    int M = Integer.parseInt(br.readLine());

    if (sum <= M) {
      System.out.println(max);
      return;
    }

    int start = 1;
    int end = max;

    while (start <= end) {

      int mid = (start + end) / 2;

      if (isPossible(M, mid)) {
        start = mid + 1;
      }
      else {
        end = mid - 1;
      }
    }

    System.out.println(start - 1);
  }

  static boolean isPossible(int M, int upperLimit) {
    for (int req : requests) {
      if (req > upperLimit) {
        M -= upperLimit;
        continue;
      }
      M -= req;
    }

    return M >= 0;
  }
}
