package P1260;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static boolean[][] arr;
    static int r,c;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1260/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            arr[r][c] = true;
            arr[c][r] = true;
        }

        visit = new boolean[N+1];
        dfs(V);
        sb.append("\n");

        visit = new boolean[N+1];
        bfs();

        System.out.println(sb);
    }

    public static void dfs(int node) {
        visit[node] = true;
        sb.append(node).append(" ");

        for (int i = 1; i <= N; i++) {
            if (arr[node][i] && !visit[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        visit[V] = true;
        int node;
        while (!q.isEmpty()) {
            node = q.poll();
            sb.append(node).append(" ");
            for (int i = 1; i <= N; i++) {
                if (arr[node][i] && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}
