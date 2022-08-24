package DAY01.P1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long X, Y;
    static long Z;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        X = Long.parseLong(stk.nextToken());
        Y = Long.parseLong(stk.nextToken());
        Z = Y* 100 /X;

        // parametric search 에서 가장 중요한 것 -> mid를 살릴것이냐
        if (Z >= 99) {
            System.out.println(-1);
        } else {
            long l = 0, h = X;
            while (l < h) {
                long m = (h+l)/2;
                long curZ = (Y+m)* 100 /(X+m);

                // 승률이 그대로 인 경우
                if (curZ == Z) {
                    l = m + 1;
                } else {
                // 승률이 변한 경우
                    h = m;
                }
            }

            System.out.println(h);
        }


    }
}
