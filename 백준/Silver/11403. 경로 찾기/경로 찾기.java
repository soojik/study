import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[][] connections;
    static int[][] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        connections = new boolean[N][N];
        ans = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                connections[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            dfs(i, i, new boolean[N]);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int curr, int startAt, boolean[] visit) {
        for (int i = 0; i < N; i++) {
            if (!visit[i] && connections[curr][i]) {
                visit[i] = true;
                ans[startAt][i] = 1;
                dfs(i, startAt, visit);
            }
        }
    }
}
