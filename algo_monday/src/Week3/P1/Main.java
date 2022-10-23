package Week3.P1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("algo_monday/src/Week3/P1/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            answer += Integer.parseInt(st.nextToken());
        }

        System.out.println(answer);
    }
}
