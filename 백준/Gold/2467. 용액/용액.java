import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static long[] arr;
  static long[] answer = new long[2];
  static long min;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new long[N];
    min = Long.MAX_VALUE;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N - 1; i++) {
      BS(i);
    }

    System.out.println(answer[0] + " " + answer[1]);
  }

  static void BS(int idx) {

    int mid;
    int startIdx = idx + 1;
    int endIdx = N - 1;
    while (startIdx <= endIdx) {
      mid = (startIdx + endIdx) / 2;

      long diff = arr[idx] + arr[mid];

      if (Math.abs(diff) < min) {
        min = Math.abs(diff);
        answer = new long[]{arr[idx], arr[mid]};
      }

      if (diff < 0) {
        startIdx = mid + 1;
      }
      else {
        endIdx = mid - 1;
      }
    }
  }
}
