package P9184;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a, b, c;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][][] check;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P9184/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        check = new int[50][50][50];

        while (true) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a, b, c)).append("\n");
        }

        System.out.println(sb);
    }

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }
        if (check[a][b][c] == 0 && (a < b && b < c)) {
            return check[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }

        if (check[a][b][c] == 0) {
            return check[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }

        return check[a][b][c];
    }

}
