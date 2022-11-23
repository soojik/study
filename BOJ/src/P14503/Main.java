package P14503;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static int r, c, d;
    static int[][] map;
    static int answer = 0;
    static int nx, ny, nd;
    static boolean valid;

    // 북 동 남 서
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P14503/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) answer++;
            }
        }

        System.out.println(answer);
    }

    static void dfs(int x, int y, int d) {
        map[x][y] = 2;

        valid = false;
        nd = d;
        for (int i = 0; i < 4; i++) {
            nd = (nd + 3) % 4;
            nx = x + dr[nd];
            ny = y + dc[nd];

            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (map[nx][ny] == 0) {
                    dfs(nx, ny, nd);
                    valid = true;
                    break;
                }
            }
        }

        if (!valid) {
            nd = (d + 2) % 4;
            nx = x + dr[nd];
            ny = y + dc[nd];

            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (map[nx][ny] != 1) {
                    dfs(nx, ny, d);
                }
            }
        }
    }
}