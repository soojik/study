package P1149;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] RGB;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P1149/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        RGB = new int[N][3];

        StringTokenizer st;
        for (int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            RGB[t][0] = Integer.parseInt(st.nextToken());
            RGB[t][1] = Integer.parseInt(st.nextToken());
            RGB[t][2] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i < N; i++) {
            RGB[i][0] += Math.min(RGB[i - 1][1], RGB[i - 1][2]);
            RGB[i][1] += Math.min(RGB[i - 1][0], RGB[i - 1][2]);
            RGB[i][2] += Math.min(RGB[i - 1][1], RGB[i - 1][0]);
        }

        answer = Math.min(RGB[N - 1][0], Math.min(RGB[N - 1][1], RGB[N - 1][2]));
        System.out.println(answer);
    }
}
