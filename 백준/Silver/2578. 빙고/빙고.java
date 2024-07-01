import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[26][2];
        boolean[][] checked = new boolean[5][5];
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[Integer.parseInt(st.nextToken())] = new int[]{i, j};
            }
        }

        int num;
        int r, c;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                num = Integer.parseInt(st.nextToken());
                r = board[num][0];
                c = board[num][1];

                checked[r][c] = true;

                if (3 <= isBingo(checked)) {
                    System.out.println(i * 5 + j + 1);
                    return;
                }
            }
        }
        System.out.println(25);
    }

    static int isBingo(boolean[][] checked) {
        int result = 0;
        for (int i = 0; i < 5; i++) {
            boolean v_flag = true;
            boolean h_flag = true;
            for (int j = 0; j < 5 && (v_flag || h_flag); j++) {
                if (!checked[i][j]) {
                    h_flag = false;
                }
                if (!checked[j][i]) {
                    v_flag = false;
                }
            }
            if (h_flag) ++result;
            if (v_flag) ++result;
        }

        boolean flag_rl = true;
        boolean flag_lr = true;
        for (int i = 0; i < 5 && (flag_rl || flag_lr); i++) {
            if (!checked[i][i]) {
                flag_rl = false;
            }
            if (!checked[i][4-i]) {
                flag_lr = false;
            }
        }

        if (flag_rl) ++result;
        if (flag_lr) ++result;

        return result;
    }
}
