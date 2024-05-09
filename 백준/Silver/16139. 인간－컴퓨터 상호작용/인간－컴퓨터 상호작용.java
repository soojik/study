import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int N = Integer.parseInt(br.readLine());

        int[][] alpha_cnt = new int[line.length()][26];

        ++alpha_cnt[0][line.charAt(0) - 'a'];
        for (int i = 1; i < line.length(); i++) {
            alpha_cnt[i] = Arrays.copyOf(alpha_cnt[i - 1], alpha_cnt[i - 1].length);
            ++alpha_cnt[i][line.charAt(i) - 'a'];
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");

            int c_idx = cmd[0].charAt(0) - 'a';
            int start_idx = Integer.parseInt(cmd[1]);
            int end_idx = Integer.parseInt(cmd[2]);

            if (start_idx == 0) {
                sb.append(alpha_cnt[end_idx][c_idx]).append("\n");
                continue;
            }
            sb.append(alpha_cnt[end_idx][c_idx] - alpha_cnt[start_idx - 1][c_idx]).append("\n");
        }

        System.out.println(sb);
    }
}
