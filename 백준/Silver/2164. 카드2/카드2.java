import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            q.addLast(i+1);
        }

        while (1 < q.size()) {
            q.pollFirst();
            q.addLast(q.pollFirst());
        }

        System.out.println(q.pollFirst());
    }
}
