import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] visit;
    static boolean[][] isLand;
    static int r_len, c_len;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r_len = Integer.parseInt(st.nextToken());
        c_len = Integer.parseInt(st.nextToken());
        
        isLand = new boolean[r_len][c_len];
        for (int i = 0; i < r_len; i++) {
            String line = br.readLine();
            for (int j = 0; j < c_len; j++) {
                isLand[i][j] = line.charAt(j) == 'L';
            }
        }

        int max = 0;
        for (int i = 0; i < r_len; i++) {
            for (int j = 0; j < c_len; j++) {
                if (isLand[i][j]) {
                    visit = new boolean[r_len][c_len];
                    max = Math.max(max, bfs(i, j));

                }
            }
        }

        System.out.println(max);
    }

    static int bfs(int start_r, int start_c) {
        int max = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start_r, start_c, 0});
        visit[start_r][start_c] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int curr_r = curr[0];
            int curr_c = curr[1];
            int curr_cnt = curr[2];

            max = Math.max(curr_cnt, max);

            for (int i = 0; i < 4; i++) {
                int nr = curr_r + dr[i];
                int nc = curr_c + dc[i];
                if (0 <= nr && nr < r_len && 0 <= nc && nc < c_len) {
                    if (isLand[nr][nc] && !visit[nr][nc]) {
                        visit[nr][nc] = true;
                        q.add(new int[]{nr, nc, curr_cnt + 1});
                    }
                }
            }
        }

        return max;
    }
}
