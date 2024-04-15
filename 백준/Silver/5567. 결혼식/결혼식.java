import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ans = 0;
    static int N, M;
    static boolean[][] connections;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        connections = new boolean[N+1][N+1];

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            connections[b][a] = connections[a][b] = true;
        }

        visit = new boolean[N + 1];
        visit[1] = true;
        for (int i = 2; i <= N; i++) {
            if (!connections[1][i]) continue;

            if (!visit[i]) {
                ++ans;
                visit[i] = true;
            }
            dfs(i, 1);
        }

        System.out.println(ans);
    }

    static void dfs(int num, int depth) {
        if (depth == 2) {
            return;
        }

        for (int i = 2; i <= N; i++) {
            if (!connections[num][i]) continue;

            if (!visit[i]) {
                ++ans;
                visit[i] = true;
            }
            dfs(i, depth + 1);
        }
    }
}
