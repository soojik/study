import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int p1 = 0;
        int p2 = arr.length - 1;

        int ans = 0;
        while (p1 < p2) {
            int sum = arr[p1] + arr[p2];
            if (sum < X) {
                ++p1;
            } else if (sum == X) {
                ++p1;
                --p2;
                ++ans;
            } else {
                --p2;
            }
        }

        System.out.println(ans);
    }
}
