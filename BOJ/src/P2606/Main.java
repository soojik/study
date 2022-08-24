package P2606;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int u, v;
    static boolean[][] map;
    static boolean[] visit;
    static int cnt = -1;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2606/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            map[u][v] = true;
            map[v][u] = true;
        }

        visit = new boolean[N+1];
        dfs(1);
        System.out.println(cnt);

        visit = new boolean[N+1];
        cnt = 0;
        bfs();
        System.out.println(cnt);
    }

    public static void dfs(int node) {
        visit[node] = true;
        cnt++;

        for (int i = 1; i <= N; i++) {
            if (map[node][i] && !visit[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int i = 1; i <= N; i++) {
                if (map[node][i] && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                    cnt++;
                }
            }
        }
    }
}
