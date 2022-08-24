package P2669;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2669/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[101][101];

        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            fill_map(x1, y1, x2, y2);
        }


        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (map[i][j] == 1) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static void fill_map(int x1, int y1, int x2, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                map[i][j] = 1;
            }
        }
    }
}
