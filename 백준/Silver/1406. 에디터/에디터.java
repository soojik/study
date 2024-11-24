import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Deque<Character> left = new ArrayDeque<>();
    Deque<Character> right = new ArrayDeque<>();

    String input_str = br.readLine();
    for (char c : input_str.toCharArray()) {
      left.addLast(c);
    }

    int test = Integer.parseInt(br.readLine());
    while (test-- > 0) {
      String[] splited = br.readLine().split(" ");
      String cmd = splited[0];

      // 입력
      if (cmd.equals("P")) {
        left.addLast(splited[1].charAt(0));
      }
      /*
      L	커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
      D	커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
      B	커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
      삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
       */
      if (cmd.equals("L")) {
        if (left.isEmpty()) continue;
        right.addFirst(left.removeLast());
      }
      if (cmd.equals("D")) {
        if (right.isEmpty()) continue;
        left.addLast(right.removeFirst());
      }
      if (cmd.equals("B")) {
        if (left.isEmpty()) continue;
        left.removeLast();
      }
    }

    StringBuffer sb = new StringBuffer();
    while (!left.isEmpty()) {
      sb.append(left.removeFirst());
    }
    while (!right.isEmpty()) {
      sb.append(right.removeFirst());
    }
    System.out.println(sb);
  }
}
