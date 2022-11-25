package P1535;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P1535/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });

        dp = new int[N][2];

        for (int i = 0; i < N; i++) {
            if (arr[i][0] < 100) {
                dp[i][0] = arr[i][0];
                dp[i][1] = arr[i][1];
            }
            for (int j = 0; j < i; j++) {
                if (dp[j][0] + arr[i][0] < 100) {
                    if (dp[i][1] < dp[j][1] + arr[i][1]) {
                        dp[i][1] = dp[j][1] + arr[i][1];
                        dp[i][0] = dp[j][0] + arr[i][0];
                    }
                }
            }
        }

        // for (int i = 0; i < N; i++) {
        //     System.out.println(arr[i][0] + " " + arr[i][1]);
        // }
        
        // for (int i = 0; i < N; i++) {
        //     System.out.println(dp[i][0] + " " + dp[i][1]);
        // }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i][1]);
        }

        System.out.println(max);
    }
}
