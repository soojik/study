package DAY01.P3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int row, column;
    static char[][] map;
    static int[][] check;
    static Queue<node> q;
    static int[] mr = {0, -1, 0, 1};
    static int[] mc = {-1, 0, 1, 0};
    static boolean foundAnswer;

    static public class node {
        int x;
        int y;
        char type;

        public node(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    static public void main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);

        row = in.nextInt();
        column = in.nextInt();

        map = new char[row][column];
        check = new int[row][column];

        q = new LinkedList<>();

        node tmp = null;
        for (int r=0;r<row;r++) {
            String input = in.next();
            for (int c=0;c<column;c++) {
                map[r][c] = input.charAt(c);
                if (map[r][c] == '*') {
                    q.add(new node(r, c, '*'));
                }
                if (map[r][c] == 'S') {
                    tmp = new node(r, c, 'S');
                }
            }
        }

        q.add(tmp);

        while(!q.isEmpty()) {
            node cur = q.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
            char cur_type = cur.type;

            if (cur_type == 'D') {
                System.out.println(check[cur_x][cur_y]);
                foundAnswer = true;
                return;
            }

            // 연결된 곳을 순회 -> 상하좌우
            for (int i=0;i<4;i++) {
                // 갈 수 있는가? (공통) ; 맵 안?
                if (cur_x + mr[i] >= 0 && cur_x + mr[i] < row && cur_y + mc[i] >= 0 && cur_y + mc[i] < column) {
                    if ((cur_type == 'S' || cur_type == '.') && check[cur_x+mr[i]][cur_y+mc[i]] == 0) {
                        // 갈 수 있는가? (고슴도치) :. or D, 방문하지 않은 곳
                        if ((map[cur_x+mr[i]][cur_y+mc[i]] == '.' || map[cur_x+mr[i]][cur_y+mc[i]] == 'D')) {
                            // 체크인 (고슴도치)
                            check[cur_x+mr[i]][cur_y+mc[i]] = check[cur_x][cur_y] + 1;
                            // 큐에 삽입
                            q.add(new node(cur_x + mr[i], cur_y + mc[i], map[cur_x + mr[i]][cur_y + mc[i]]));
                        }
                    } else if (cur_type == '*') {
                        // 갈 수 있는가? (물) : ., S
                        if (map[cur_x+mr[i]][cur_y+mc[i]] == '.' || map[cur_x+mr[i]][cur_y+mc[i]] == 'S') {
                            // 체크인 (물) : map[][] = *
                            map[cur_x+mr[i]][cur_y+mc[i]] = '*';
                            // 큐에 삽입
                            q.add(new node(cur_x + mr[i], cur_y + mc[i], '*'));
                        }
                    }
                }
            }

        }
        if (!foundAnswer) System.out.println("KAKTUS");
    }

}
