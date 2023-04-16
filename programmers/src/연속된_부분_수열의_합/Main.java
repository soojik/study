package 연속된_부분_수열의_합;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5}, 7)));
    System.out.println(Arrays.toString(solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)));
    System.out.println(Arrays.toString(solution(new int[]{2, 2, 2, 2, 2}, 6)));
  }

  public static int[] solution(int[] sequence, int k) {
    int[] answer = new int[2];

    int start = 0;
    int end = 0;
    int sum = sequence[0];

    if (sum == k) {
      return answer;
    }

    sum += sequence[++end];

    int len = sequence.length;

    int last_diff = Integer.MAX_VALUE;

    while (start <= end) {
      if (end == len - 1) {
        if (sum == k) {
          if (last_diff > end - start) {
            answer[0] = start;
            answer[1] = end;

            last_diff = answer[1] - answer[0];
          }
        }
        sum -= sequence[start++];
      }
      else {
        if (sum == k) {
          if (last_diff > end - start) {
            answer[0] = start;
            answer[1] = end;

            last_diff = answer[1] - answer[0];
          }
          sum -= sequence[start++];
          sum += sequence[++end];
        }
        else if (sum > k) {
          sum -= sequence[start++];
        }
        else {
          sum += sequence[++end];
        }
      }
    }

    return answer;
  }
}
