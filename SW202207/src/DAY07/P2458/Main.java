package DAY07.P2458;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer>[] students;
    static int[] inCnt, outCnt;
    static boolean[] visit;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAY07/P2458/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        students = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            students[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            students[a].add(b);
        }

        inCnt = new int[N+1];
        outCnt = new int[N+1];

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N+1];
            outCnt[i] = dfs(i);
        }

        for (int i = 1; i <= N; i++) {
            if (inCnt[i] + outCnt[i] == N) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static int dfs(int now) {
        int outCnt = 0;
        for (int next : students[now]) {
            if (visit[next]) {
                continue;
            }
            inCnt[next]++;
            visit[next] = true;
            outCnt += dfs(next);
        }
        return outCnt + 1;
    }
}
