package DAY01.P1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());

        trees = new int[N];

        int max = 0;
        for (int i=0;i<N;i++) {
            trees[i] = Integer.parseInt(stk.nextToken());
            max = Math.max(max, trees[i]);
        }

        int start = 0, end = max;
        int mid;
        int min = max;
        long sum;

        while(true) {
            mid = (start+end) / 2;
            sum = calc(mid);
            if (sum == M) {
                min = mid;
                break;
            } else if (sum < M) {
                end = mid - 1;
            } else {
                min = mid; // == min = Math.min(min, mid); 어차피 mid가 작음
                start = mid + 1;
            }

            if (start > end) break;

            /*

            mid = (start+end) / 2;
            sum = calc(mid);
            // sum == M
            // sum > M : start = mid + 1
            if (sum > M) {
                min = Math.min(min, mid);
                start = mid + 1;
            } else if (sum < M) {
                // sum < M : end = mid - 1
                end = mid - 1;
            }

            if (sum == M) {
                min = mid;
                break;
            }

            if (start > end) break;
             */
        }
        System.out.println(min);
    }

    static public long calc (long value) {
        long result = 0;

        for (int i=0;i<N;i++) {
            if (trees[i] > value) result += trees[i]-value;
        }

        return result;
    }
}
