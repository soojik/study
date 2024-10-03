import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    // 합, 쓰인 수
    int[][] cnt = new int[201][201];

    for (int i = 0; i <= N; i++) {
      cnt[i][1] = 1;
    }

    for (int k = 2; k <= K; k++) {
      cnt[0][k] = 1;
      for (int n = 1; n <= N; n++) {
        cnt[n][k] = (cnt[n - 1][k] + cnt[n][k - 1]) % 1000000000;
      }
    }

    System.out.println(cnt[N][K]);
  }
}
