public class 숫자의표현 {

  public static void main(String[] args) {
    System.out.println(solution(15));
  }

  static int solution(int n) {
    int answer = 0;

    int[] dp = new int[n + 1];

    for (int i=1;i<=n;i++) dp[i] = i + dp[i-1];

    int start = 0;
    int end = 1;

    int len = dp.length;
    while (end < len) {
      int sum = dp[end] - dp[start];

      if (sum == n) {
        ++start;
        ++end;
        ++answer;
      }
      else if (sum > n) {
        ++start;
      }
      else {
        ++end;
      }
    }

    return answer;
  }
}
