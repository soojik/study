package P11053;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P11053/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        for (int i = 0; i < N; i++) {
            // i번째 원소가 증가하는 수열의 마지막 원소라고 가정하고
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                // 0 ~ i-1번째 원소, j번째 원소를 돌며
                // 1-1. j번째 원소가 i번째 원소보다 작으며
                // 1-2. j번째 까지의 증가 수열 길이를 저장한 dp[j]가 dp[i]보다 같거나 길면
                    // == i번째 원소가 증가수열에서 j번째 원소의 바로 뒤에 붙어 이어나갈 수 있단 말이므로
                // 2. i번째 증가 수열 길이에 j번째 까지의 증가 수열 길이 +1 해준다.
                // 0부터 i-1번째까지 원소를 돌며 i가 최대 어디 뒤에 붙을 수 있는지 검사하는 것이 목적
                if (arr[j] < arr[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
