package P10451;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static int[][] graph;
    static boolean[] visit;
    static int answer;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P10451/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        for (int t = 0; t < K; t++) {
            N = Integer.parseInt(br.readLine());

            graph = new int[N+1][N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int x = Integer.parseInt(st.nextToken());
                graph[i][x] = 1;
            }

            visit = new boolean[N+1];
            answer = 0;
            for (int i = 1; i <= N; i++) {
                if (!visit[i]) {
                    answer++;
                    dfs(i);
                }
            }

            System.out.println(answer);
        }
    }

    public static void dfs(int node) {
        visit[node] = true;

        for (int i = 1; i <= N; i++) {
            if (graph[node][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }
}
