import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = stoi(br.readLine());

    // 입력받을 카드 가격 배열
    int[] nums = new int[1001];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      nums[i] = stoi(st.nextToken());
    }

    // i 개의 카드살 때 쓸 수 있는 최대한의 비용
    int[] dp = new int[1001];
    dp[1] = nums[1];

    // 2부터 N까지
    for (int i = 2; i <= N; i++) {
      // 1 + i-1, 2 + i-2, ... i + 0 까지 검사하며 최댓값을 구하는데 i의 반까지만 구하면 된다.
      int half = i / 2;
      // 그냥 i개 패키지 그대로 샀을 때로 초기화
      dp[i] = nums[i];
      // 순회하며 최댓값 업데이트
      for (int j = 1; j <= half; j++) {
        dp[i] = Math.max(dp[i], dp[i - j] + nums[j]);
      }
    }

    System.out.println(dp[N]);
  }
}
