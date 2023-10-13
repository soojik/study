import java.io.*;

public class Main {
  static int T;
  static int stoi(String s) {return Integer.parseInt(s);}
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    T = stoi(br.readLine());

    // dp[i][j] -> f(i)를 호출했을 때, f(j)이 호출되는 횟수
    int[][] dp = new int[41][2];
    dp[0][0] = 1;
    dp[0][1] = 0;
    dp[1][0] = 0;
    dp[1][1] = 1;

    for (int i = 2; i <= 40; i++) {
      for (int j = 0; j < 2; j++) {
        dp[i][j] = dp[i - 2][j] + dp[i - 1][j];
      }
    }

    int N;
    StringBuilder sb;
    for (int i = 0; i < T; i++) {
      sb = new StringBuilder();
      N = stoi(br.readLine());
      sb.append(dp[N][0]).append(" ").append(dp[N][1]);
      bw.write(sb.append("\n").toString());
    }

    bw.flush();
  }
}
