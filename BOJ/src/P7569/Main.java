package P7569;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int[][][] map;
    static boolean[][][] visit;
    static int[] dx = {0, -1, 0, 1, 0, 0};
    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P7569/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        visit = new boolean[H][N][M];
        Queue<Tomato> q = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 1 && !visit[i][j][k]) {
                        visit[i][j][k] = true;
                        q.add(new Tomato(j, k, i));
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Tomato temp = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                int nz = temp.z + dz[i];

                if (0 <= nz && nz < H && 0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (!visit[nz][nx][ny]) {
                        if (map[nz][nx][ny] == 0) {
                            visit[nz][nx][ny] = true;
                            q.add(new Tomato(nx, ny, nz));
                            map[nz][nx][ny] = map[temp.z][temp.x][temp.y] + 1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, map[i][j][k]);
                }
            }
        }

        System.out.println(answer-1);
    }
}

class Tomato {
    int x;
    int y;
    int z;

    public Tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}