package P11408;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("BOJ/src/P11408/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] map = new int[N+1][M+1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] expect = new int[N+1][M+1];

    for (int i=1;i<=N;i++) {
      for (int j=1;j<=M;j++) {
        expect[i][j] = Math.max(expect[i-1][j-1], Math.max(expect[i-1][j], expect[i][j-1])) + map[i][j];
      }
    }

    System.out.println(expect[N][M]);
  }
}
