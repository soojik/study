import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> flights;
    static Queue<int[]> q;
    static int ans;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            flights = new ArrayList<List<Integer>>();
            for (int i = 0; i <= N; i++) flights.add(new ArrayList<>());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                flights.get(a).add(b);
                flights.get(b).add(a);
            }

            sb.append(N-1).append("\n");
        }

        System.out.println(sb);
    }

    static boolean bfs(int start) {
        // 현재 국가, 방문한 국가 수, 탄 비행편 수
        q = new LinkedList<>();
        visit = new boolean[N + 1];
        q.add(new int[]{start, 1, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            visit[curr[0]] = true;
            System.out.println(curr[1] == N);

            if (curr[1] == N) {
                ans = Math.min(ans, curr[2]);
                return true;
            }

            for (int next : flights.get(curr[0])) {
                q.add(new int[]{next, visit[next] ? curr[1] : curr[1] + 1, curr[2] + 1});
            }
        }

        return false;
    }
}
