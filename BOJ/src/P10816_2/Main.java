package P10816_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] cards;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P10816/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(BS(target));
            sb.append(" ");
        }

        System.out.println(sb);
    }

    static int BS(int target) {
        int start = 0, end = cards.length - 1;

        while (start < cards.length - 1 && cards[start] < target) {
            start++;
        }

        while (end >= start && cards[end] > target) {
            end--;
        }

        if (end >= start) {
            return end - start + 1;
        } else {
            return 0;
        }
    }
}
