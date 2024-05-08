import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        while (true) {
            String line = br.readLine();

            if (line.equals(".")) {
                System.out.println(sb);
                return;
            }

            Stack<Character> stack = new Stack<>();
            for (char c : line.toCharArray()) {
                if (Character.isAlphabetic(c) || c == ' ' || c == '.') continue;

                if (c == '(' || c == '[' || stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                if (c == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                        continue;
                    }
                    stack.push(c);
                }
                if (c == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                        continue;
                    }
                    stack.push(c);
                }
            }
            sb.append(stack.isEmpty() ? "yes" : "no").append("\n");
        }
        
    }
}
