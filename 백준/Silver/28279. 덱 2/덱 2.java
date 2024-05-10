import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");

            int cmd1 = Integer.parseInt(cmd[0]);
            switch (cmd1) {
                case 1:
                    q.addFirst(Integer.parseInt(cmd[1]));
                    break;
                case 2:
                    q.addLast(Integer.parseInt(cmd[1]));
                    break;
                case 3:
                    sb.append(q.isEmpty() ? -1 : q.pollFirst()).append("\n");
                    break;
                case 4:
                    sb.append(q.isEmpty() ? -1 : q.pollLast()).append("\n");
                    break;
                case 5:
                    sb.append(q.size()).append("\n");
                    break;
                case 6:
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 7:
                    sb.append(q.isEmpty() ? -1 : q.peekFirst()).append("\n");
                    break;
                case 8:
                    sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
