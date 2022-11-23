package P2178;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int row, column;
    static int[][] map;
    static int[][] visit;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P2178/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        map = new int[row+1][column+1];
        for (int i = 1; i <= row; i++) {
            String line = br.readLine();
            for (int j = 1; j <= column; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j-1)));
            }
        }

        visit = new int[row+1][column+1];
        bfs();
        System.out.println(visit[row][column]);
    }

    public static void bfs() {
        Queue<Info> q = new LinkedList<>();

        q.add(new Info(1, 1));
        visit[1][1] = 1;

        while (!q.isEmpty()) {
            Info temp = q.poll();

            if (temp.r == row && temp.c == column) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int next_r = temp.r + dr[i];
                int next_c = temp.c + dc[i];

                if (1 <= next_r && next_r <= row && 1 <= next_c && next_c <= column) {
                    if (visit[next_r][next_c] == 0 && map[next_r][next_c] == 1) {
                        q.add(new Info(next_r, next_c));
                        visit[next_r][next_c] = visit[temp.r][temp.c] + 1;
                    }
                }
            }
        }
    }
}

class Info {
    int r;
    int c;

    public Info (int r, int c) {
        this.r = r;
        this.c = c;
    }
}
