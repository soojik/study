import java.util.Stack;

public class 올바른괄호 {

  public static void main(String[] args) {
    System.out.println(solution("()()"));
    System.out.println(solution("(())()"));
    System.out.println(solution(")()("));
    System.out.println(solution("(()("));
  }

  static boolean solution(String s) {
    Stack<Character> stack = new Stack<>();

    char[] arr = s.toCharArray();

    for (char c : arr) {
      // stack 비어있다면 비교할게 없으니까 그냥 삽입
      if (stack.empty()) {
        // 이미 틀린 답이니까 false 반환
        if (c == ')') return false;
        stack.push(c);
        continue;
      }

      // 닫는 괄호 나오면
      if (c == ')') {
        // stack 에서 마지막 값이 짝이 맞는지 확인 후
        if (stack.peek() == '(') {
          // 빼냄
          stack.pop();
          continue;
        }
      }

      // 짝이 맞는 상황 아니면 무조건 push
      stack.push(c);
    }

    return stack.empty();
  }
}
