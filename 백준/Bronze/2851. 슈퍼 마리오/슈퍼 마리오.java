import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            int curr = Integer.parseInt(br.readLine());
            ans += curr;
            if (100 <= ans) {
                int diff1 = Math.abs(100 - (ans));
                int diff2 = Math.abs(100 - (ans - curr));
                if (diff1 <= diff2) {
                    System.out.println(ans);
                    return;
                }
                System.out.println(ans - curr);
                return;
            }
        }
        System.out.println(ans);
    }
}
