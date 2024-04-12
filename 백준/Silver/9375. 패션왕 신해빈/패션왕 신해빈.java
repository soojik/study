import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            HashMap<String, HashSet<String>> wears = new HashMap<>();
            int N = Integer.parseInt(br.readLine());

            for (int j = 0; j < N; j++) {
                String[] arr = br.readLine().split(" ");
                if (!wears.containsKey(arr[1])) wears.put(arr[1], new HashSet<>());
                wears.get(arr[1]).add(arr[0]);
            }

            int ans = 1;
            for (String key : wears.keySet()) {
                ans *= (wears.get(key).size() + 1);
            }

            System.out.println(ans - 1);
        }
    }

    public int getCombi(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        result /= num;

        return result;
    }
}
