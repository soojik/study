import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[][] conn;
  static int[] max;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    conn = new int[N + 1][N + 1];
    for (int i = 0; i <= N; i++) {
      Arrays.fill(conn[i], 10000001);
    }
    max = new int[N + 1];
    int num1, num2;
    StringTokenizer st;
    while (true) {
      st = new StringTokenizer(br.readLine());
      num1 = Integer.parseInt(st.nextToken());
      num2 = Integer.parseInt(st.nextToken());

      if (num1 == -1 && num2 == -1) break;

      conn[num1][num2] = conn[num2][num1] = 1;
    }

    for (int k = 1; k <= N; k++) {
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          conn[i][j] = Math.min(conn[i][j], conn[i][k] + conn[k][j]);
        }
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= N; i++) {
      int max = 0;
      for (int j = 1; j <= N; j++) {
        if (i == j) continue;
        max = Math.max(max, conn[i][j]);
      }
      min = Math.min(min, max);
    }

    List<Integer> answer = new ArrayList<>();
    for (int i = 1; i <= N; i++) {
      int max = 0;
      for (int j = 1; j <= N; j++) {
        if (i == j) continue;
        max = Math.max(max, conn[i][j]);
      }
      if (max == min) {
        answer.add(i);
      }
    }

    StringBuffer sb = new StringBuffer();
    sb.append(min).append(" ").append(answer.size()).append("\n");
    for (Integer i : answer) sb.append(i).append(" ");

    System.out.println(sb);
  }


}
