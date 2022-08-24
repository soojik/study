package P2644;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int a, b;
    static int test;
    static boolean[][] graph;
    static boolean[] visit;
    static int answer = -1;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2644/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        test = Integer.parseInt(br.readLine());

        graph = new boolean[N+1][N+1];
        for (int i = 0; i < test; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            graph[parent][child] = true;
            graph[child][parent] = true;
        }

        visit = new boolean[N+1];
        dfs(a, 0);
        System.out.println(answer);
    }

    public static void dfs(int node, int depth) {
        visit[node] = true;

        if (node == b) {
            answer = depth;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (graph[node][i] && !visit[i]) {
                dfs(i, depth+1);
            }
        }
    }
}
