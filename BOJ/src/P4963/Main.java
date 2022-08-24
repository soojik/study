package P4963;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int W, H;
    static int[][] map;
    static boolean[][] visit;
    static StringTokenizer st;
    static int answer;

    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P4963/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (W == 0 && H == 0) {
                break;
            }

            map = new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer = 0;

            visit = new boolean[H][W];
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!visit[i][j] && map[i][j] == 1) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(answer);
        }

    }

    public static void dfs(int r, int c) {
        visit[r][c] = true;

        for (int i = 0; i < 8; i++) {
            int next_r = r + dr[i];
            int next_c = c + dc[i];

            if (0 <= next_r && next_r < H && 0 <= next_c && next_c < W) {
                if (!visit[next_r][next_c] && map[next_r][next_c] == 1) {
                    dfs(next_r, next_c);
                }
            }
        }
    }
}

