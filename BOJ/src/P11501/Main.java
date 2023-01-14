package P11501;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/src/P11501/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int days = Integer.parseInt(br.readLine());

            int[] stocks = new int[days];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < days; i++) {
                stocks[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            long earn = 0;
            for (int i = days - 1; i >= 0; i--) {
                if (max < stocks[i]) {
                    max = stocks[i];
                } else {
                    earn += max - stocks[i];
                }
            }

            /* 앞에서부터 순회하며 떨어지기 직전에 전에 사놨던 주가들을 팔도록 구현한 알고리즘 - 오답
            long sum = 0;
            int cnt = 0;
            long earn = 0;
            for (int i = 1; i <= days; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

                if (arr[i - 1] > arr[i]) {
                    earn += arr[i - 1] * (cnt - 1) - (sum - arr[i - 1]);
                    sum = arr[i];
                    cnt = 1;
                } else {
                    sum += arr[i];
                    cnt++;
                }
            }

            earn += arr[days] * (cnt - 1) - (sum - arr[days]);

            if (earn <= 0) {
                System.out.println(0);
                continue;
            }
             */

            System.out.println(earn);

        }
    }
}
