package Week3.P4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] tanks;
    static boolean[] visit;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("algo_monday/src/Week3/P4/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tanks = new boolean[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            tanks[from][to] = tanks[to][from] = true;
        }

        visit = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            visit[i] = true;
            dfs(i);
            visit[i] = false;
        }

        for (Integer answer : list) {
            System.out.println(answer);
        }
    }

    static void dfs (int target) {
        for (int i = 1; i < N + 1; i++) {

            if (tanks[target][i] && !visit[i]) {
                visit[i] = true;
                dfs(target);
                visit[i] = false;
            }
        }
    }
}
