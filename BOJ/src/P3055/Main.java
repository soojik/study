package P3055;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static int dr[] = {0, -1, 0, 1};
    static int dc[] = {-1, 0, 1, 0};
    // check[][] 배열 사용해 해당 위치까지의 거리 기록
    static int[][] cnt;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P3055/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Queue<Info> queue = new LinkedList<>();

        map = new char[R][C];

        Info temp = null;
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == '*') {
                    queue.add(new Info(i, j, '*'));
                } else if (map[i][j] == 'S') {
                    temp = new Info(i, j, 'S');
                }
            }
        }
        queue.add(temp);

        cnt = new int[R][C];
        boolean FoundAnswer = false;

        while (!queue.isEmpty()) {
            Info cur = queue.poll();

            if (cur.state == 'D') {
                System.out.println(cnt[cur.x][cur.y]);
                FoundAnswer = true;
                break;
            }

            // * -> 상하좌우 .나 S는 *로 바꿔
            if (cur.state == '*') {
                for (int i = 0; i < 4; i++) {
                    int next_x = cur.x + dr[i];
                    int next_y = cur.y + dc[i];
                    if (0 <= next_x && next_x < R && 0 <= next_y && next_y < C) {
                        if (map[next_x][next_y] == '.' || map[next_x][next_y] == 'S') {
                            map[next_x][next_y] = '*';
                            queue.add(new Info(next_x, next_y, '*'));
                        }
                    }
                }
            }

            // S -> 상하좌우 .면 S로 바꿔
                // check 상하좌우 +1
            else if (cur.state == 'S' || cur.state == '.') {
                for (int i = 0; i < 4; i++) {
                    int next_x = cur.x + dr[i];
                    int next_y = cur.y + dc[i];
                    if (0 <= next_x && next_x < R && 0 <= next_y && next_y < C) {
                        // 다음 칸 . or D
                        if ((map[next_x][next_y] == '.' || map[next_x][next_y] == 'D') && cnt[next_x][next_y] == 0) {
                            cnt[next_x][next_y] = cnt[cur.x][cur.y] + 1;
                            queue.add(new Info(next_x, next_y, map[next_x][next_y]));
                        }
                    }
                }
            }

        }

        if (!FoundAnswer) {
            System.out.println("KAKTUS");
        }
    }
}

class Info {
    int x;
    int y;
    char state;

    public Info(int x, int y, char info) {
        this.x = x;
        this.y = y;
        this.state = info;
    }
}