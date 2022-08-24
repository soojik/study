package DAY06.P1717;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] parent;
    // union 최적화 하기 위함
    static int[] depth;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAY06/P1717/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            depth[i] = parent[i] = i;
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cmd == 0) {
                union(a, b);
            } else if (cmd == 1) {
                if (find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            // 왜 parent[a] = find(parent[a]) -> 루트를 해당 경로를 지나가는 모든 원소에게 루트 명시해주기
            return parent[a] = find(parent[a]);
        }
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        parent[aRoot] = bRoot;
    }
}
