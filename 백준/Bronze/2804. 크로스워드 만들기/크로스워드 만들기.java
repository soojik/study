import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int len_A = A.length();
        int len_B = B.length();

        int same_idx_A = 0;
        int same_idx_B = 0;
        boolean flag = true;
        for (int i = 0; i < len_A && flag; i++) {
            for (int j = 0; j < len_B; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    same_idx_A = j;
                    same_idx_B = i;
                    flag = false;
                    break;
                }
            }
        }

        char[][] map = new char[len_B][len_A];
        for (char[] m : map) Arrays.fill(m, '.');
        for (int i = 0; i < len_A; i++) {
            map[same_idx_A][i] = A.charAt(i);
        }
        for (int i = 0; i < len_B; i++) {
            map[i][same_idx_B] = B.charAt(i);
        }

        StringBuffer sb = new StringBuffer();
        for (char[] m : map) {
            for (char c : m) {
                sb.append(c);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
