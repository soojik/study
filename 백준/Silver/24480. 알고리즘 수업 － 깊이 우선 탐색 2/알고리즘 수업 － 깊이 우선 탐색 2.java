import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, R;
    static List<List<Integer>> graph = new ArrayList<>();
    static int depth = 0;
    static int[] ans;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        ans = new int[N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        visit[R] = true;
        dfs(R);

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int idx) {
        ans[idx] = ++depth;

        if (depth == N + 1) {
            return;
        }
        
        for (int next : graph.get(idx)) {
            if (visit[next]) continue;
            visit[next] = true;
            
            dfs(next);
        }
    }
}
