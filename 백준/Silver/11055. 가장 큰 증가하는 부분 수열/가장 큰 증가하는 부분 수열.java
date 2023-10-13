import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[] nums;
  static int[] sum;
  static int stoi(String s) {return Integer.parseInt(s);}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = stoi(br.readLine());

    nums = new int[N];
    // sum[i]: 0부터 i번째 인덱스까지의 부분 수열 중 증가하는 부분의 합
    sum = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      sum[i] = nums[i] = stoi(st.nextToken());
    }

    sum[0] = nums[0];

    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        if (nums[i] < nums[j] && sum[j] < sum[i] + nums[j]) {
          sum[j] = sum[i] + nums[j];
        }
      }
      if (sum[i] == 0) sum[i] = nums[i];
    }

    int max_sum = 0;
    for (int i = 0; i < N; i++) {
      max_sum = Math.max(max_sum, sum[i]);
    }

    System.out.println(max_sum);
  }
}
