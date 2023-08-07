import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[] opers = new int[4];
  static int[] nums;
  static long max = Integer.MIN_VALUE;
  static long min = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    nums = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    // + - * /
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      opers[i] = Integer.parseInt(st.nextToken());
    }

    dfs(nums[0], 1);

    System.out.println(max);
    System.out.println(min);
  }

  static void dfs(long sum, int num_idx) {
    if (num_idx == N) {
      max = Math.max(max, sum);
      min = Math.min(min, sum);
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (opers[i] <= 0) continue;

      --opers[i];
      switch (i) {
        case 0:
          dfs(sum + nums[num_idx], num_idx + 1);
          break;
        case 1:
          dfs(sum - nums[num_idx], num_idx + 1);
          break;
        case 2:
          dfs(sum * nums[num_idx], num_idx + 1);
          break;
        case 3:
          dfs(sum / nums[num_idx], num_idx + 1);
          break;
      }
      ++opers[i];
    }
  }
}
