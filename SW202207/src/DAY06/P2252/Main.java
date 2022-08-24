package DAY06.P2252;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N, M;
    static int[] front;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAY06/P2252/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        front = new int[N+1];
        List<Integer>[] students = new ArrayList[N+1];
        for (int i = 0; i < N + 1; i++) {
            students[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            students[from].add(to);
            front[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (front[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");

            for (int next : students[now]) {
                front[next]--;
                if (front[next] == 0) {
                    queue.add(next);
                }
            }
        }
        System.out.println(sb);
    }
}
