import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] check;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check = new boolean[N][N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j] && map[i][j] == 1) {
                    dfs_num(i, j, ++cnt);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 1) {
                    check = new boolean[N][N];
                    bfs(i, j);
                }
            }
        }

        System.out.println(min);
    }

    public static void dfs_num(int x, int y, int cnt) {
        check[x][y] = true;
        map[x][y] = cnt;

        for (int i = 0; i < 4; i++) {
            int nx = x + dr[i];
            int ny = y + dc[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (map[nx][ny] == 1 && !check[nx][ny]) {
                    dfs_num(nx, ny, cnt);
                }
            }
        }
    }

    public static void bfs(int x, int y) {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(x, y, 0));
        check[x][y] = true;

        int land = map[x][y];
        while (!q.isEmpty()) {
            Info curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dr[i];
                int ny = curr.y + dc[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (map[nx][ny] != land && !check[nx][ny]) {
                        if (map[nx][ny] == 0) {
                            q.add(new Info(nx, ny, curr.cnt+1));
                            check[nx][ny] = true;
                        }
                        else {
                            min = Math.min(min, curr.cnt);
                        }
                    }
                }
            }
        }
    }
}

class Info {
    int x;
    int y;
    int cnt;

    public Info (int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}