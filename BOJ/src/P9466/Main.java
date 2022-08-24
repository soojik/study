package P9466;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int test;
    static int N;
    static int[] students;
    static boolean[] visit;
    static boolean[] finished;
    static int answer;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P9466/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            N = Integer.parseInt(br.readLine());

            students = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            visit = new boolean[N + 1];
            finished = new boolean[N + 1];
            answer = 0;

            for (int i = 1; i <= N; i++) {
                if (!finished[i]) {
                    dfs(i);
                }
            }

            System.out.println(N - answer);
        }
    }

    public static void dfs(int node) {
        if (finished[node]) {
            return;
        }

        if (visit[node]) {
            finished[node] = true;
            answer++;
        }

        visit[node] = true;
        dfs(students[node]);
        visit[node] = false;
        finished[node] = true;
    }
}
