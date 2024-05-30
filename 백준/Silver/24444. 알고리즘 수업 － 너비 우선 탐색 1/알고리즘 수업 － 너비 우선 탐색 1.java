import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        int depth = 1;
        int[] ans = new int[N + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(R);

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (ans[curr] == 0) ans[curr] = depth++;

            if (depth == N + 1) {
                break;
            }

            for (int next : graph.get(curr)) {
                if (ans[next] != 0) continue;

                q.add(next);
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append("\n");
        }

        System.out.println(sb);
    }
}
