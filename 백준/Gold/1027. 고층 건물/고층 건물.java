import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[] buildings;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    buildings = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      buildings[i] = Integer.parseInt(st.nextToken());
    }

    int max = 0;
    for (int i = 0; i < N; i++) {
      int sum = 0;
      double left_diff = Double.POSITIVE_INFINITY;
      double right_diff = Double.NEGATIVE_INFINITY;
      double diff;
      for (int j = i + 1; j < N; j++) {
        diff = (double) (buildings[j] - buildings[i]) / (j - i);

        if (right_diff < diff) {
          ++sum;
          right_diff = diff;
        }
      }

      for (int j = i - 1; j >= 0; j--) {
        diff = (double) (buildings[j] - buildings[i]) / (j - i);

        if (diff < left_diff) {
          ++sum;
          left_diff = diff;
        }
      }
      max = Math.max(max, sum);
    }

    System.out.println(max);
  }
}
