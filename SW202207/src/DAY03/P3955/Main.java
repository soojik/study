package DAY03.P3955;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, A, B;
    public static void main(String[] args) throws IOException, FileNotFoundException {
        System.setIn(new FileInputStream("src/DAY03/P3955"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // X : 인당 나눠줄 사탕의 수
        // Y : 사탕 봉지의 수
        // A * x + 1 = B * y
        // Ax + By = C 의 형태로 변환
        // -Ax + By = 1
        // A(-x) + By = 1

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            // 1. 해 검증
            // D = gcb(A, B) = egcd(A,B).r
            // Ax + By = C 일때 C%D == 0 이어야 해를 가질 수 있음 : 베주 항정식
            // C % D != 0 -> 해가 없음

            // 2. 초기 해 구하기
            // x0 = s * C / D
            // y0 = t * C / D


            // 3. 일반 해 구하기
            // x = x0 + B / D * k
            // y = y0 - A / D * k
            // x0, B, D 다 아는데 k를 몰라

            // while <- k ->

            // 4. k의 범위
            // x < 0 (우린 앞에서 -x로 바꿔줬기 때문에)
            // x0 + B * k < 0
            // k < - x0 / B

            // 0 < y <= 1e9
            // 0 < y0 -A * k <= 1e9
            // -y0 < -A * k  <= 1e9 - y0
            // (y0 - le9) / A <= k < y0 / A

            // (y0 - le9) / A <= k < y0 / A
            //                   k < - x0 / B


        }

    }

    /*
    long a, long b

    long s0 = 1, t0 = 0, r0 = a;
    long s1 = 0, s1 = 1, r1 = b;

    long temp;
    while (r1 != 0) {
        long q = r0 / r1;

        temp = r0 - q * r1;
        r0 = r1;
        r1 = temp;

        temp = s0 - q * s1;
        s0 = s1;
        s1 = temp;

        temp = t0 - q * t1;
        t0 = t1;
        t1 = temp;
    }

    return EGResult(s0, t0, r0);
     */
}

class EGResult {
    long s;
    long t;
    long r;

    public EGResult (int s, int t, int r) {
        super();
        this.s = s;
        this.t = t;
        this.r = r;
    }
}
