import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[N];

    for (int i = 0; i < N; i++) {
      if (dp[i] == 0) dp[i] = 1;
      for (int j = i + 1; j < N; j++) {
        if (arr[i] > arr[j] && dp[i] >= dp[j]) {
          dp[j] = dp[i] + 1;
        }
      }
    }


    int max = 0;
    for (int i = 0; i < N; i++) {
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);
  }
}
