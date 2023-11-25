import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[100001];

    dp[1] = 1;
    // 거쳐온 제곱 수
    List<Integer> list = new ArrayList<>();
    list.add(1);
    for (int i = 2; i <= 100000; i++) {
      dp[i] = i;
      // 제곱수라면
      if (Math.sqrt(i) % 1 == 0) {
        // 무조건 1
        dp[i] = 1;
        // 마지막 제곱수 갱신
        list.add(i);
        continue;
      }

      // 거쳐온 제곱 수를 순회하며 dp[i-제곱수] + dp[제곱수], 즉 dp[i-제곱수] 가 최소인 곳을 찾는다.
      for (int n : list) {
        // dp[i-n] + dp[n] == dp[i]
        dp[i] = Math.min(dp[i], dp[i - n] + 1);
      }
    }

    System.out.println(dp[N]);
  }
}
