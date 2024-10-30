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
    int M = Integer.parseInt(st.nextToken());

    int[] heights = new int[M];
    st = new StringTokenizer(br.readLine());
    int answer = 0;
    for (int i = 0; i < M; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i < M - 1; i++) {
      int lwall = 0;
      int rwall = 0;

      for (int j = 0; j <= i; j++) {
        lwall = Math.max(lwall, heights[j]);
      }

      for (int j = i; j < M; j++) {
        rwall = Math.max(rwall, heights[j]);
      }

      answer += Math.min(lwall, rwall) - heights[i];
    }

    System.out.println(answer);
  }
}
