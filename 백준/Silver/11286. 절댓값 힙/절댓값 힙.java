import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (Math.abs(o1) == Math.abs(o2) ? o1 - o2 : Math.abs(o1) - Math.abs(o2));
            }
        });

        int num;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());

            if (num == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
                continue;
            }

            pq.add(num);
        }

        System.out.println(sb);
    }
}
