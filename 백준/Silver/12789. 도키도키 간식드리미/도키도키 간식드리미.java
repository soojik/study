import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }

        int idx = 1;
        Stack<Integer> stack = new Stack<>();

        while (!q.isEmpty() && idx <= N) {
            while (!q.isEmpty() && q.peek() == idx) {
                q.poll();
                ++idx;
            }
            while (!stack.isEmpty() && stack.peek() == idx) {
                stack.pop();
                ++idx;
            }
            while (!q.isEmpty() && q.peek() != idx) {
                stack.push(q.poll());
            }
        }

        if (q.isEmpty() && stack.isEmpty()) {
            System.out.println("Nice");
            return;
        }
        System.out.println("Sad");
    }
}
