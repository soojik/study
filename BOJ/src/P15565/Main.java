package P15565;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    /*
    라이언 인형은 1, 어피치 인형은 2로 표현하자. 라이언 인형이 K개 이상 있는 가장 작은 연속된 인형들의 집합의 크기를 구하여라.
     */

    static int N, K;
    static int[] dolls;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.setIn(new FileInputStream("src/P15565/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        dolls = new int[N];

        stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            dolls[i] = Integer.parseInt(stk.nextToken());
        }

        int start = 0, end = 0, cnt = 0, result = Integer.MAX_VALUE;
        while (end < N) {
            if (cnt < K) {
                if (dolls[end++] == 1) {
                    cnt++;
                }
            } else {
                result = Math.min(result, end-start);
                if (dolls[start++] == 1) {
                    --cnt;
                }
            }
        }
        if (cnt >= K) {
            while (dolls[start] == 2 && start < N) {
                start++;
            }
            result = Math.min(result, end-start);
        }

        if (result == Integer.MAX_VALUE) {
            result = -1;
        }
        System.out.println(result);

    }
}
