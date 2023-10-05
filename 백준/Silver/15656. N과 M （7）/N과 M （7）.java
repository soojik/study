import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int n, m;
  static int[] nums;
  static boolean[] visit;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    nums = new int[n];
    visit = new boolean[n];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(nums);

    backtracking(0, new int[m]);

    bw.flush();

  }

  static void backtracking(int depth, int[] answer) {
    if (depth == m) {
      StringBuilder sb = new StringBuilder();
      for (int i : answer) sb.append(i).append(" ");
      try {
        bw.write(sb.append("\n").toString());
      } catch (IOException e) {
        System.out.println(e.getLocalizedMessage());
      }
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visit[i]) {
        answer[depth] = nums[i];
        backtracking(depth + 1, answer);
      }
    }
  }
}
