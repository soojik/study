import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = stoi(br.readLine());

    Stack<Integer> stack = new Stack<>();

    int[] nums = new int[n];

    for (int i = 0; i < n; i++) nums[i] = stoi(br.readLine());

    StringBuilder sb = new StringBuilder();
    int idx = 0;
    for (int i = 1; i <= n && idx < n; i++) {
      // 비었거나 이전 나왔던 숫자 보관하는 스택의 맨 위에 있는 값이 혅재 찾아야하는 값과 다르다면
      if (stack.isEmpty() || stack.peek() != nums[idx]) {
        // 현재 i를 스택에 넣어주고
        stack.push(i);
        // 표시
        sb.append("+").append("\n");
      }

      // 후에 스택에서 값 비교하며
      while (!stack.isEmpty() && stack.peek() == nums[idx]) {
        // 뽑고 표시
        stack.pop();
        sb.append("-").append("\n");
        // 다음 찾을 수로 넘어가기
        ++idx;
      }
    }

    if (stack.isEmpty()) {
      System.out.println(sb);
    }
    else
      System.out.println("NO");
  }
}
