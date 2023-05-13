import java.util.Arrays;
import java.util.Stack;

public class 뒤에있는큰수찾기 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(new int[]{2, 3, 3, 5})));
    System.out.println(Arrays.toString(solution(new int[]{9, 1, 5, 3, 6, 2})));
  }

  public static int[] solution(int[] numbers) {
    int len = numbers.length;
    int[] answer = new int[len];

    Stack<Integer> stack = new Stack<>();

    for (int i=len-1;i>=0;i--) {
      while (!stack.empty() && stack.peek() <= numbers[i]) {
        stack.pop();
      }
      if (stack.empty()) {
        answer[i] = -1;
      }
      else {
        answer[i] = stack.peek();
      }
      stack.push(numbers[i]);
    }

    return answer;
  }
}
