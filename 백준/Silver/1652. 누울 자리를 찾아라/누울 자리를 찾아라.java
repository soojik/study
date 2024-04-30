import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[][] isEmpty = new boolean[N][N];
        int row_ans = 0;
        for (int i = 0; i < N; i++) {
            String input_str = br.readLine();
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                isEmpty[i][j] = input_str.charAt(j) == '.';
                if (!isEmpty[i][j]) {
                    if (2 <= cnt) {
                        ++row_ans;
                    }
                    cnt = 0;
                    continue;
                }
                ++cnt;
            }
            if (2 <= cnt) {
                ++row_ans;
            }
        }

        int col_ans = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (!isEmpty[j][i]) {
                    if (2 <= cnt) {
                        ++col_ans;
                    }
                    cnt = 0;
                    continue;
                }
                ++cnt;
            }
            if (2 <= cnt) {
                ++col_ans;
            }
        }

        System.out.println(row_ans + " " + col_ans);
    }
}
