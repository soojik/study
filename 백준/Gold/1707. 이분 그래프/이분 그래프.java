import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K, V, E;
    static List<List<Integer>> conn;
    static int[] color; // 1 OR -1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        while (0 < K--) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            conn = new ArrayList<>();
            color = new int[V + 1];
            for (int i = 0; i <= V; i++) {
                conn.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                conn.get(a).add(b);
                conn.get(b).add(a);
            }

            boolean check = true;
            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    if (!bfs(i)) {
                        check = false;
                    }
                }
            }

            sb.append(check ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }

    static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        color[start] = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : conn.get(curr)) {
                if (color[next] == 0) {
                    q.add(next);
                    color[next] = (color[curr] == 1) ? -1 : 1;
                    continue;
                }
                if (color[curr] == color[next]) {
                    return false;
                }
            }
        }

        return true;
    }
}
