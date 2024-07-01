import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {arr[i] = Integer.parseInt(st.nextToken());}

        boolean isIncreasing = false;
        int max = 0;
        int start_height = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i - 1] < arr[i] && !isIncreasing) {
                isIncreasing = true;
                start_height = arr[i - 1];
            }
            if (arr[i] <= arr[i - 1] && isIncreasing) {
                isIncreasing = false;
                max = Math.max(max, arr[i - 1] - start_height);
            }
        }
        if (isIncreasing)
            max = Math.max(max, arr[N - 1] - start_height);

        System.out.println(max);
    }
}
