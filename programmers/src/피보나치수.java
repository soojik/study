public class 피보나치수 {

  public static void main(String[] args) {
    System.out.println(solution(3));
    System.out.println(solution(5));
  }

  static int solution(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;

    int idx = 1;
    while (++idx <= n) {
      dp[idx] = (dp[idx-1] + dp[idx-2]) % 1234567;
    }

    return dp[n];
  }
}
