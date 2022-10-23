package Week3.P3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static boolean[][] bridge;
    static int[] cnt;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("algo_monday/src/Week3/P3/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bridge = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            bridge[from][to] = true;
            bridge[to][from] = true;
        }

        cnt = new int[N + 1];
        visit = new boolean[N + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int from = q.poll();
            visit[from] = true;

            for (int i = 1; i < N + 1; i++) {
                if (bridge[from][i] && !visit[i]) {
                    q.add(i);
                    cnt[i] = cnt[from] + 1;
                    if (i == M) {
                        min = Math.min(min, cnt[i]);
                    }
                }
            }
        }

        if (min <= K) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}