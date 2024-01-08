import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  /*
  0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.
  덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N, K;
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    // {i, j} -> j개의 숫자를 이용해 i를 만드는 경우의 수
    int[][] dp = new int[N + 1][K + 1];

    for (int i = 1; i <= K; i++) {
      dp[1][i] = i; // 1개의 1과 K-1개의 0을 나열하는 경우의 수
      /*
      K = 2 (2)
        0 + 1, 1 + 0
      K = 3 (3)
        0 + 0 + 1, 0 + 1 + 0, 1 + 0 + 0
       */
    }

    for (int i = 2; i <= N; i++) {
      dp[i][1] = 1;
      /*
      e.g.) N = 2
      K = 2 (3)
        0 + 2, 1 + 1, 2 + 0
      K = 3 (6)
        0 + 0 + 2, 0 + 2 + 0, 2 + 0 + 0, 1 + 1 + 0, 1 + 0 + 1, 0 + 1 + 1
        ...

      e.g.) N = 3
      K = 2 (4)
        0 + 3, 1 + 2, 2 + 1, 3 + 0
      K = 3 (10)
        0 + 0 + 3, 0 + 3 + 0, 3 + 0 + 0, 3 P 3 (0, 1, 2) == 6, 1 + 1 + 1
       */
      for (int j = 2; j <= K; j++) {
        dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
      }
    }

    System.out.println(dp[N][K]);
  }
}
