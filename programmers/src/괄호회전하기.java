import java.util.Stack;

public class 괄호회전하기 {

  public static void main(String[] args) {
    System.out.println(solution("[](){}"));
    System.out.println(solution("}]()[{"));
    System.out.println(solution("[)(]"));
    System.out.println(solution("{{{"));
  }

  static int solution(String s) {
    int total = s.length();

    // 회전 수에서 만족하지 않을 때마다 1씩 감소
    int answer = total;

    for (int i=0;i<total;i++) {
      Stack<Character> stack = new Stack<>();

      // StringBuilder 로 기준 s에서 0~total-1 기준으로 잘라 반대로 붙여서 회전하는 것처럼 만들었다.
      StringBuilder sb = new StringBuilder("");
      sb.append(s.substring(i, total)).append(s.substring(0, i));

      for (int j=0;j<total;j++) {
        char c = sb.charAt(j);

        // 여는 괄호이거나 stack 에 값이 없다면 괄호를 넣어주고
        if (c == '[' || c == '(' || c == '{' || stack.isEmpty()) {
          stack.add(c);
        }
        // 닫는 괄호이면서 stack 에 값이 있다면
        else {
          char next = stack.peek();
          // 가장 위의 괄호가 현재 c(괄호) 와 쌍이 맞는지 확인 후, 맞다면 stack 에서 빼준다.
          if ((c == ']' && next == '[')
                  || (c == '}' && next == '{')
                  || (c == ')' && next == '(')) {
            stack.pop();
          }
        }
      }
      // 회전한 sb 문자열 탐색을 끝낸 후에 stack 에 괄호가 남아 있다면 조건에 맞지 않는다는 뜻이므로 answer 에서 1 감소
      if (!stack.isEmpty()) {
        --answer;
      }
    }

    return answer;
  }
}
