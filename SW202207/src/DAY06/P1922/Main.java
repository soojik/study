package DAY06.P1922;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAY06/P1922/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 가중치에 대해 오름차순으로
        PriorityQueue<int[]> qp = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            qp.add(new int[]{a, b, w});
        }

        int cnt = 0, result = 0;
        while (cnt < N-1 && !qp.isEmpty()) {
            int[] node = qp.poll();
            // 둘이 조상노드가 다르다면
            if (find(node[0]) != find(node[1])) {
                // 둘이 이어, cnt++, result += 가중치
                union(node[0], node[1]);
                cnt++;
                result += node[2];
            }
        }

        System.out.println(result);
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[a] = b;
    }
}
