package P7576;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] check;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P7576/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Tomato> q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    q.add(new Tomato(i, j));
                }
            }
        }

        check = new int[M][N];

        while (!q.isEmpty()) {
            Tomato curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = curr.x + dr[i];
                int next_y = curr.y + dc[i];

                if (0 <= next_x && next_x < M && 0 <= next_y && next_y < N) {
                    if (map[next_x][next_y] == 0 && check[next_x][next_y] == 0) {
                        map[next_x][next_y] = 1;
                        check[next_x][next_y] = check[curr.x][curr.y] + 1;
                        q.add(new Tomato(next_x, next_y));
                    }
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(check[i][j], answer);
            }
        }

        System.out.println(answer);
    }
}

class Tomato {
    int x;
    int y;

    public Tomato (int x, int y) {
        this.x = x;
        this.y = y;
    }
}