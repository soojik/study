package P11404;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("BOJ/src/P11404/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int E = Integer.parseInt(br.readLine());

    long[][] arr = new long[N + 1][N + 1];
    for (int i = 0; i <= N; i++) {
      Arrays.fill(arr[i], Integer.MAX_VALUE);
    }

    StringTokenizer st;
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr[a][b] = Math.min(arr[a][b], c);
    }

    for (int k = 1; k <= N; k++) {
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          if (i == j) continue;

          arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
        }
      }
    }

    StringBuffer sb = new StringBuffer();
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        sb.append(arr[i][j] == Integer.MAX_VALUE ? 0 : arr[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
