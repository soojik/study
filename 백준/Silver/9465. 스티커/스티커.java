import java.io.*;
import java.util.StringTokenizer;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder answer = new StringBuilder();

    int T = stoi(br.readLine());

    int N;
    StringTokenizer st;
    for (int t = 0; t < T; t++) {
      N = stoi(br.readLine());

      int[][] stickers = new int[2][N];

      for (int i = 0; i < 2; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          stickers[i][j] = stoi(st.nextToken());
        }
      }

      int[][] dp = new int[2][N];
      dp[0][0] = stickers[0][0];
      dp[1][0] = stickers[1][0];

      for (int i = 1; i < N; i++) {
        // 직전 열에서 같은 행에 있는(한 변이 붙어있는) 스티커를 냅두는 경우, 직전 열에 다른 행의 스티커를 냅두는 경우
        // 후자는 현재 스티커도 합쳐서 최댓값을 비교해 업데이트해나간다.
        dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + stickers[0][i]); 
        dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] + stickers[1][i]);
      }

      answer.append(Math.max(dp[0][N - 1], dp[1][N - 1])).append("\n");
    }

    System.out.print(answer);
  }
}
