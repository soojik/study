import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int[] dp = new int[N];
    Arrays.fill(dp, 1);

    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        if (arr[i] < arr[j] && dp[i] >= dp[j]) {
          dp[j] = dp[i] + 1;
        }
      }
    }

    int max = 0;
    for (int d : dp) {
      max = Math.max(max, d);
    }

    System.out.println(N - max);
  }
}
