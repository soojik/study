package P11054;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    static int[] dp_rev;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        dp_rev = new int[N];

        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        dp_rev[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            dp_rev[i] = 1;

            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i] && dp_rev[j] >= dp_rev[i]) {
                    dp_rev[i] = dp_rev[j] + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(dp[i] + dp_rev[i], answer);
        }

        System.out.println(answer - 1);
    }
}
