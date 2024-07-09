import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[][] apps;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    apps = new int[N + 1][2];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      apps[i][0] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      apps[i][1] = Integer.parseInt(st.nextToken());
    }

    // {i, j} -> 남은 필요한 메모리
    long[][] dp = new long[10001][N + 1];
    for (int i = 0; i <= 10000; i++) { // 쓰인 비용
      for (int j = 1; j <= N; j++) { // 배터리
        if (M <= dp[i][j]) continue;
        // 현재 쓰인 비용(i)이 현차례의 앱 교체 비용보다 크거나 같다면
        if (apps[j][1] <= i) {
          dp[i][j] = Math.max(dp[i - apps[j][1]][j - 1] + apps[j][0], dp[i][j - 1]);
        }
        else {
          dp[i][j] = dp[i][j - 1];
        }
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i <= 10000; i++) {
      for (int j = 1; j <= N; j++) {
        if (M <= dp[i][j]) {
          min = Math.min(min, i);
        }
      }
    }

    System.out.println(min);
  }

}
