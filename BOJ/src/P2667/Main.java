package P2667;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static int cnt_house;
    static List<Integer> houses;
    static String line;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2667/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            line = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j-1)));
            }
        }

        visit = new boolean[N+1][N+1];
        houses = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    cnt_house = 0;
                    dfs(new Node(i, j));
                    houses.add(cnt_house);
                }
            }
        }

        sb.append(houses.size()).append("\n");
        Collections.sort(houses);
        for (int n : houses) {
            sb.append(n).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(Node node) {
        visit[node.r][node.c] = true;
        cnt_house++;

        for (int i = 0; i < 4; i++) {
            int next_r = node.r + dr[i];
            int next_c = node.c + dc[i];

            if (1 <= next_r && next_r <= N && 1 <= next_c && next_c <= N) {
                if (map[next_r][next_c] == 1 && !visit[next_r][next_c]) {
                    dfs(new Node(next_r, next_c));
                }
            }
        }
    }
}

class Node {
    int r, c;

    public Node (int r, int c) {
        this.r = r;
        this.c = c;
    }
}