package Day2.P4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int num;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Day2/P4/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            explode(r, c);
        }

        System.out.println(answer);
    }

    static void explode(int r, int c) {
        answer++;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (0 < nr && nr <= N && 0 < nc && nc <= N) {
                answer++;
            }
        }
    }
}
