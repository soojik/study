import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] isPalindrome;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        isPalindrome = new boolean[N + 1][N + 1];

        // 길이가 홀수
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N/2 + 1 && 1 <= (i-j) && (i+j) <= N; j++) {
                if (nums[i - j] == nums[i + j]) {
                    isPalindrome[i - j][i + j] = true;
                    continue;
                }
                break;
            }
        }

        // 길이가 짝수
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N/2 + 1 && 1 <= (i-j-1) && (i+j) <= N; j++) {
                if (nums[i - j - 1] == nums[i + j]) {
                    isPalindrome[i - j - 1][i + j] = true;
                    continue;
                }
                break;
            }
        }

        StringBuilder ans = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            ans.append(isPalindrome[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] ? 1 : 0).append("\n");
        }

        System.out.println(ans);
    }
}
