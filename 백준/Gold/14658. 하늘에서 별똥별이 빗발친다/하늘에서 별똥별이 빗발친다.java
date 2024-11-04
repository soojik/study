import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N, M, L, K;
  static int[][] stars;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    stars = new int[K][2];

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      stars[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
    }

    int max = 0;

    for (int i = 0; i < K; i++) {
      for (int j = 0; j < K; j++) {
        int min_x = Math.min(stars[i][0], stars[j][0]);
        int min_y = Math.min(stars[i][1], stars[j][1]);
        int cnt = 0;

        for (int k = 0; k < K; k++) {
          if (min_x <= stars[k][0] && stars[k][0] <= min_x + L
          && min_y <= stars[k][1] && stars[k][1] <= min_y + L) {
            ++cnt;
          }
        }
        max = Math.max(max, cnt);
      }
    }


    System.out.println(K - max);
  }
}
