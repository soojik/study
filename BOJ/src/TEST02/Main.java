package TEST02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] woods;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/TEST02/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        woods = new int[N];
        for (int i = 0; i < N; i++) {
            woods[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(woods);
        int min = woods[N-1];

        int start = 0, end = min;

        while (start < min) {
            int mid = (start + end) / 2;

            // sum < K -> end 땡겨
            // sum > K -> start 땡겨
            // sum == K -> start 땡겨
            if (cut_wood(mid) < K) {
                end = mid - 1;
            } else if (cut_wood(mid) > K) {
                start = mid + 1;
            } else {
                start = mid;
            }
        }

        System.out.println(end);
    }

    public static int cut_wood(int x) {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += woods[i] / x;
        }

        return sum;
    }
}
