package P7570;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/src/P7570/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int now = 0;
        int max = 0;
        for (int i = 1; i <= N; i++) {
            now = Integer.parseInt(st.nextToken());
            max = Math.max(max, dp[now] = dp[now - 1] + 1);
        }

        System.out.println(N - max);
    }
}
