import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder answer = new StringBuilder();

    int test = 0;
    int N;
    int[][] arr;
    long[][] dp;
    StringTokenizer st;
    while (true) {
      if ((N = stoi(br.readLine())) == 0) break;

      ++test;
      arr = new int[N][3];
      dp = new long[N][3];

      for (int i=0;i<N;i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 3; j++) {
          arr[i][j] = stoi(st.nextToken());
        }
      }

      // 두번째 줄 초기화
      // 무조건 첫번째 줄은 중간에서 시작하니까
      dp[1][0] = arr[0][1] + arr[1][0];
      dp[1][1] = Math.min(dp[1][0], Math.min(arr[0][1], arr[0][1] + arr[0][2])) + arr[1][1];
      dp[1][2] = Math.min(dp[1][1], Math.min(arr[0][1], arr[0][2] + arr[0][1])) + arr[1][2];

      for (int i = 2; i < N; i++) {
        dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][0];
        dp[i][1] = Math.min(dp[i][0], Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2]))) + arr[i][1];
        dp[i][2] = Math.min(dp[i][1], Math.min(dp[i - 1][1], dp[i - 1][2])) + arr[i][2];
      }

      answer.append(test + ". " + dp[N-1][1]).append("\n");
    }

    System.out.println(answer);
  }
}
