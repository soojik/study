import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.equals("ENTER")) {
                ans += set.size();
                set = new HashSet<>();
                continue;
            }
            set.add(str);
        }

        System.out.println(ans + set.size());
    }
}
