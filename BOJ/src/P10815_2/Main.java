package P10815_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] cards;
    static int[] to_find;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/src/P10815_2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        to_find = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            to_find[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        for (int i = 0; i < M; i++) {
            sb.append(BinarySearch(0, N - 1, to_find[i])).append(" ");
        }

        System.out.println(sb);
    }

    static String BinarySearch(int low, int high, int target) {
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;

            // mid가 target보다 작다면 low = mid + 1
            if (cards[mid] < target) {
                low = mid + 1;
            }

            // mid가 target보다 크다면 high = mid - 1
            else if (cards[mid] > target) {
                high = mid - 1;
            }

            // mid가 target과 일치하다면
            else {
                return "1";
            }
        }

        return "0";
    }
}
