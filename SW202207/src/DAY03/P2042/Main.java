package DAY03.P2042;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // M은 수의 변경이 일어나는 횟수이고, K는 구간의 합을 구하는 횟수이다.
    static int N, M, K;
    static int S;
    static int[] data;
    static int[] tree;

    public static void main(String[] args) throws IOException, FileNotFoundException {
        System.setIn(new FileInputStream("src/DAY03/P2042/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        S = 1;
        while (S < N) {
            S *= 2;
        }

        data = new int[S];
        for (int i=0;i<N;i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        /*
        a가 1인 경우 b(1 ≤ b ≤ N)번째 수를 c로 바꾸고
        a가 2인 경우에는 b(1 ≤ b ≤ N)번째 수부터 c(b ≤ c ≤ N)번째 수까지의 합을 구하여 출력하면 된다.
         */

        initBU();

        for (int i=0;i<M+K;i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            if (a == 1) {
                Update(1, S, 1, b, c-data[b-1]);
            } else if (a == 2) {
                System.out.println(Query(1, S, 1, b, c));
            }
        }

    }
    static void initBU () {
        tree = new int[S*2];

        for (int i=S;i<2*S;i++) {
            tree[i] = data[i-S];
        }
        for (int i=S-1;i>0;i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

//        for (int i : tree) System.out.println(i);
    }

    static long Query(int left, int right, int node, int QLeft, int QRight) {

        // 아예 접점 X
        if (right < QLeft || QRight < left) {
            return 0;
        }

        // 연관 있는 경우
        else if (QLeft <= left && right <= QRight) {
            return tree[node];
        }

        // 자식은 알 수 있는 경우
        else {
            int mid = (left + right) / 2;
            long leftVal = Query(left, mid, node * 2, QLeft, QRight);
            long rightVal = Query(mid + 1, right, node * 2 + 1, QLeft, QRight);
            return leftVal + rightVal;
        }
    }

    static void Update(int left, int right, int node, int target, int diff) {
        // 노드가 target 미포함 -> 연관 X
        if (target < left || right < target) {
            return;
        } else {
            // 포함 -> 현재 노드에 diff 반영
            tree[node] += diff;
            // 단말 노드까지 수정
            if (left != right) {
                int mid = (left + right) / 2;
                Update(left, mid, node * 2, target, diff);
                Update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }
}

