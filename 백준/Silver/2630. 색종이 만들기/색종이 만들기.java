import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] ans = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0, 0, N);

        for (int a : ans) {
            System.out.println(a);
        }
    }

    static void func(int start_r, int start_c, int len) {
        int color = arr[start_r][start_c];
        if (len == 0 || valid(start_r, start_c, len, color)) {
            ++ans[color];
            return;
        }

        int half_len = len / 2;
        func(start_r, start_c, half_len);
        func(start_r + half_len, start_c, half_len);
        func(start_r, start_c + half_len, half_len);
        func(start_r + half_len, start_c + half_len, half_len);
    }

    static boolean valid(int start_r, int start_c, int len, int color) {
        for (int i = start_r; i < start_r + len; i++) {
            for (int j = start_c; j < start_c + len; j++) {
                if (color != arr[i][j]) return false;
            }
        }

        return true;
    }
}
