import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
  static int[] nums;
  static int N;
  static int max = Integer.MIN_VALUE;
  static int min = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    nums = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    int[] ops = new int[4];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      ops[i] = Integer.parseInt(st.nextToken());
    }

    func(ops, 1, nums[0]);

    System.out.println(max);
    System.out.println(min);
  }

  // 모든 연산자 조합 만들어서 결과 만들어가기 
  static void func(int[] ops, int idx, int sum) {
    if (idx == N) {
      max = Math.max(max, sum);
      min = Math.min(min, sum);
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (ops[i] == 0) continue;
      // 연산자가 남아있다면 타입에 따라 sum 업데이트해주고 탐색 진행
      --ops[i];
      if (i == 0) {
        func(ops,idx + 1, sum + nums[idx]);
      } else if (i == 1) {
        func(ops,idx + 1, sum - nums[idx]);
      } else if (i == 2) {
        func(ops,idx + 1, sum * nums[idx]);
      } else {
        func(ops,idx + 1, sum / nums[idx]);
      }
      ++ops[i];
    }
  }
}
