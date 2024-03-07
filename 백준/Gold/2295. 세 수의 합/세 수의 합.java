import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N;
  static int[] nums;
  static int[] sumOfTwo;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    nums = new int[N];
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(nums);

    sumOfTwo = new int[N * N];
    int idx = 0;
    for (int i = 0; i < N; i++) {
      for (int j = i; j < N; j++) {
        sumOfTwo[idx++] = nums[i] + nums[j];
      }
    }

    Arrays.sort(sumOfTwo);

    int max = 0;
    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        if (Arrays.binarySearch(sumOfTwo, nums[j] - nums[i]) >= 0) {
          max = Math.max(nums[j], max);
        }
      }
    }

    System.out.println(max);

  }

}
