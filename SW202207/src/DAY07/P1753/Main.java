package DAY07.P1753;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int V, E;
    static int start;
    static List<int[]>[] list;
    static int[] D;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/DAY07/P1753/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        list = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new int[]{v, w});
        }

        D = new int[V+1];
        Arrays.fill(D, Integer.MAX_VALUE);

        dijkstra();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(D[i] == Integer.MAX_VALUE ? "INF" : D[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void dijkstra() {
        PriorityQueue<Route> pq = new PriorityQueue<>();
        pq.add(new Route(start, 0));
        D[start] = 0;

        while (!pq.isEmpty()) {
            Route now = pq.poll();
            if (D[now.v] < now.w) {
                continue;
            }
            for (int[] next : list[now.v]) {
                if (D[next[0]] > now.w + next[1]) {
                    D[next[0]] = now.w + next[1];
                    pq.offer(new Route(next[0], D[next[0]]));
                }
            }
        }
    }
}

class Route implements Comparable<Route> {
    int v;
    int w;

    public Route (int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Route o) {
        return w - o.w;
    }
}
