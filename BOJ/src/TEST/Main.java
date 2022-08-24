package TEST;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] cards;
    static int[] find;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/TEST/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // cards 정렬
        Arrays.sort(cards);

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(up(target) - down(target)).append(" ");
        }

        System.out.println(sb);
    }

    public static int up(int target) {
        int start = 0, end = N;
        int mid = 0;

        while (start < end) {
            mid = (start + end) / 2;

            if (cards[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    public static int down(int target) {
        int start = 0, end = N;
        int mid = 0;

        while (start < end) {
            mid = (start + end) / 2;

            if (cards[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
