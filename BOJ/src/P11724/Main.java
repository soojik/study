package P11724;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int u, v;
    static boolean[][] graph;
    static boolean[] visit;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P11724/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[u][v] = true;
            graph[v][u] = true;
        }

        visit = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int node) {
        visit[node] = true;

        for (int i = 1; i <= N; i++) {
            if (graph[node][i] && !visit[i]) {
                dfs(i);
            }
        }
    }
}
