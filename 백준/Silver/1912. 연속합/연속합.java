import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());

    int num = Integer.parseInt(st.nextToken());
    int answer = dp[0] = num;
    for (int i = 1; i < N; i++) {
      num = Integer.parseInt(st.nextToken());
      dp[i] = Math.max(dp[i - 1] + num, num);
      answer = Math.max(answer, dp[i]);
    }

    System.out.println(answer);
  }
}
