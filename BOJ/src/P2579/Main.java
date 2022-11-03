package P2579;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] stairs;
    static int[] scores;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P2579/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        stairs = new int[301];
        scores = new int[301];

        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine()); 
        }

        scores[1] = stairs[1];
        scores[2] = stairs[1] + stairs[2];
        scores[3] = Math.max(stairs[1], stairs[2]) + stairs[3];

        for (int i = 4; i <= N; i++) {
            scores[i] = Math.max(scores[i - 3] + stairs[i - 1], scores[i - 2]) + stairs[i];
        }

        System.out.println(scores[N]);
    }
}
