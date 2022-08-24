package P1707;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int V, E;
    static int[][] graph;
    static int[] group;
    static int a, b;
    static String answer = "YES";

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1707/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        for (int t = 0; t < K; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new int[V + 1][V + 1];
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                graph[a][b] = graph[b][a] = 1;
            }

            group = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                if (group[i] == 0) {
                    dfs(i, 1);
                }
            }

            System.out.println(answer);
        }
    }

    public static void dfs(int node, int color) {
        group[node] = color;

        for (int i = 1; i <= V; i++) {
            if (graph[node][i] == 1 && group[i] != color) {
                dfs(i, color*(-1));
            }
            else if (graph[node][i] == 1 && group[i] == color) {
                answer = "NO";
                return;
            }
        }
    }
}
