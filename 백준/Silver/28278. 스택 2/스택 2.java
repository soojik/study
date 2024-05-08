import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
3: 스택에 들어있는 정수의 개수를 출력한다.
4: 스택이 비어있으면 1, 아니면 0을 출력한다.
5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        for (int t = 0; t < T; t++) {
            String cmd = br.readLine();

            if (cmd.toCharArray()[0] == '1') {
                stack.push(Integer.parseInt(cmd.split(" ")[1]));
                continue;
            }
            if (cmd.equals("2")) {
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(stack.pop()).append("\n");
                continue;
            }
            if (cmd.equals("3")) {
                sb.append(stack.size()).append("\n");
                continue;
            }
            if (cmd.equals("4")) {
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                continue;
            }
            if (cmd.equals("5")) {
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(stack.peek()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
