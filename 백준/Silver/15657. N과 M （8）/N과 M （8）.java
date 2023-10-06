import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int n, m;
  static int[] nums;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    nums = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(nums);

    backtracking(0, 0, new int[m]);

    bw.flush();
  }

  static void backtracking(int index, int depth, int[] answer) {
    if (depth == m) {
      StringBuilder sb = new StringBuilder();
      for (int i : answer) {
        sb.append(i).append(" ");
      }
      try {
        bw.write(sb.append("\n").toString());
      } catch (IOException e) {
        System.out.println(e.getLocalizedMessage());
      }
      return;
    }

    for (int i = index; i < n; i++) {
      answer[depth] = nums[i];
      backtracking(i, depth + 1, answer);
    }
  }
}
