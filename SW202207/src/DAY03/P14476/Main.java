package DAY03.P14476;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nums;
    static int[] gcdLtoR;
    static int[] gcdRtoL;

    public static void main(String[] args) throws IOException, FileNotFoundException {
        System.setIn(new FileInputStream("src/DAY03/P14476/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        gcdLtoR = new int[N];
        gcdRtoL = new int[N];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }

        //LtoR 만들기
        gcdLtoR[0] = nums[0];
        for (int i = 1; i < N; i++) {
            gcdLtoR[i] = gcd(gcdLtoR[i-1], nums[i]);
        }

        //RtoL 만들기
        gcdRtoL[N-1] = nums[N-1];
        for (int i = N-2; i >= 0; i++) {
            gcdRtoL[i] = gcd(gcdRtoL[i+1], nums[i]);
        }

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            int gcd = 0;
            // 0
            if (i == 0) {
                gcd = gcdRtoL[1];
            }
            // N - 1
            else if (i == N - 1) {
                gcd = gcdLtoR[N - 2];
            }
            // 중간
            else {
                gcd = gcd(gcdLtoR[i - 1], gcdRtoL[i + 1]);
            }

            if (nums[i] % gcd != 0 && gcd > max) {
                max = gcd;
                maxIndex = i;
            }
        }
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
