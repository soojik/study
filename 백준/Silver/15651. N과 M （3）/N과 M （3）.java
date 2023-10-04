import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int n, m;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    backtracking(0, new int[m]);

    bw.flush();
  }

  static void backtracking(int depth, int[] arr) throws IOException {
    if (depth == m) {
      StringBuilder sb = new StringBuilder();
      for (int i : arr) sb.append(i).append(" ");
      bw.write(sb.append("\n").toString());
      return;
    }

    for (int i = 1; i <= n; i++) {
      arr[depth] = i;
      backtracking(depth+1, arr);
    }
  }
}
