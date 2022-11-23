package Week5.P2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static boolean[][] water_visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<Node> water_queue = new LinkedList<>();
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("algo_monday/src/Week5/P2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        water_visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    water_queue.add(new Node(i, j));
                }
            }
        }

        while (true) {
            answer++;

            int size = water_queue.size();
            for (int i = 0; i < size; i++) {
                water();
            }

            visit = new boolean[N][N];
            int island = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visit[i][j] && map[i][j] == 1) {
                        count_island(i, j);
                        island++;
                    }
                }
            }

            if (island >= 2) {
                System.out.println(answer);
                return;
            } else if (island == 0) {
                System.out.println(-1);
                return;
            }
        }
    }

    public static void water() {
        Node now = water_queue.poll();
        int x = now.x;
        int y = now.y;
        water_visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (!water_visit[nx][ny]) {
                    water_visit[nx][ny] = true;
                    map[nx][ny] = 0;
                    water_queue.add(new Node(nx, ny));
                }
            }
        }
    }

    public static void count_island(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (!visit[nx][ny] && map[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    count_island(nx, ny);
                }
            }
        }
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}