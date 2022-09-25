package P1012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N, M, C;
    static int r, c;
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    static int answer;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1012/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][M];

            for (int i = 0; i < C; i++) {
                st = new StringTokenizer(br.readLine());
                r = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

                map[r][c] = 1;
            }

            visit = new boolean[N][M];

            answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visit[i][j] && map[i][j] == 1) {
                        answer++;
                        dfs(i, j);
//                    bfs(new Info(i, j));
                    }
                }
            }

            System.out.println(answer);
        }
    }

    static void bfs(Info start) {
        Queue<Info> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Info curr = queue.poll();
            visit[curr.x][curr.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dr[i];
                int ny = curr.y + dc[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (!visit[nx][ny] && map[nx][ny] == 1) {
                        queue.add(new Info(nx, ny));
                    }
                }
            }
        }
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dr[i];
            int ny = y + dc[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (!visit[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}

class Info {
    int x;
    int y;

    public Info(int x, int y) {
        this.x = x;
        this.y = y;
    }
}