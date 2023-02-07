package P2295;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
배열 안의 수를 임의로 3개를 골라 더해서 나온 합이 배열에 속한다면, 그 합의 최댓값을 구하는 문제

처음에 문제를 잘못 이해해서 배열에 중복된 값이 없다는 것을 값을 중복으로 더할 수 없다고 알아들은 순간 완전히 꼬였다.
다른 블로그 참고해서 풀다가 이해할 수 있었다.

블로그에서 말한 것처럼 세수의 합을 구한다고 3중 반복문을 쓰게되면 시간복잡도는 O(N^3)이 되기 때문에 합을 구하는 과정을 한번 나눠야한다.
임의로 고른 세 수의 합을 x+y+z = sum 이라고 한다면
x+y = sum-z
을 이용해 처음에 임의의 두 수를 더한 배열(sumOfTwo)을 만들고 - O(N^2)
sum과 z에 대해 2중 반복문을 돌며(둘 다 처음 주어지는 배열에 있는 값) sum-z 값과 같은 요소가 sumOfTwo 배열에 있는지 확인해야한다. - O(NlogN)

참고: https://codemasterkimc.tistory.com/524
 */

public class Main {
  static int N;
  static int[] nums;
  static int[] sumOfTwo;
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("BOJ/src/P2295/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    nums = new int[N];
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(nums);

    // 임의의 두 수를 더한 배열(sumOfTwo) 생성
    sumOfTwo = new int[N * N];
    int idx = 0;
    for (int i = 0; i < N; i++) {
      for (int j = i; j < N; j++) {
        sumOfTwo[idx++] = nums[i] + nums[j];
      }
    }

    // 나중의 이분탐색을 위해 정렬
    Arrays.sort(sumOfTwo);

    // 최댓값을 구하기 위한 max 정수 선언
    int max = 0;
    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        if (BS(nums[j] - nums[i])) {
          max = Math.max(nums[j], max);
        }
      }
    }

    System.out.println(max);

  }

  // 주어진 diff(sum-z)와 같은 값이 sumOfTwo 배열에 있는지 이분탐색을 이용해 찾기
  public static boolean BS(int diff) {

    int start = 0;
    int end = N * N;

    while (start <= end) {
      int mid = (start + end) / 2;

      if (sumOfTwo[mid] > diff) {
        end = mid - 1;
      } else if (sumOfTwo[mid] < diff) {
        start = mid + 1;
      } else {
        return true;
      }
    }

    return false;
  }
}
