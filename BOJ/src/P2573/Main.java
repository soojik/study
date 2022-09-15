package P2573;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[][] map;
    static int[][] water;
    static boolean[][] visit;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static int land_cnt;
    static int years = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2573/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        water = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while (true) {
            visit = new boolean[R][C];
            land_cnt = 0;

            water = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (!visit[i][j] && map[i][j] > 0) {
                        land_cnt++;
                        dfs(i, j);
                    }
                }
            }

            if (land_cnt >= 2) {
                System.out.println(years);
                return;
            } else if (land_cnt == 0) {
                System.out.println(0);
                return;
            }

            melt();
            years++;
        }
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dr[i];
            int ny = y + dc[i];

            if (0 <= nx && nx < R && 0 <= ny && ny < C) {
                if (map[nx][ny] <= 0) {
                    water[x][y]++;
                }

                if (!visit[nx][ny] && map[nx][ny] > 0) {
                    dfs(nx, ny);
                }
            }
        }
    }

    static void melt() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    map[i][j] -= water[i][j];
                }
            }
        }
    }
}
