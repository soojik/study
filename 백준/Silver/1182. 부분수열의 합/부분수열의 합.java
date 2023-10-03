import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int N, S;
  static int[] nums;
  static int answer = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    nums = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    backtracking(-1, 0);

    System.out.println(answer);
  }

  static void backtracking(int index, int sum) {

    if (index == N) return;

    // 모든 조합을 찾으며 합(sum)이 S가 된다면 answer에 1을 더해준다.
    for (int i = index + 1; i < N; i++) {
      sum += nums[i];
      if (sum == S) ++answer;
      backtracking(i, sum);
      sum -= nums[i];
    }
  }
}
