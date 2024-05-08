import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int t = 0; t < T; t++) {
            Stack<Character> stack = new Stack<>();

            for (char c : br.readLine().toCharArray()) {
                if (stack.isEmpty() || c == '(') {
                    stack.push(c);
                    continue;
                }
                if (c == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                    else {
                        stack.push(c);
                    }
                }
            }

            if (stack.isEmpty()) {
                sb.append("YES").append("\n");
                continue;
            }

            sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }
}
