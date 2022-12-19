package P15903;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/src/P15903/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 카드 수, N의 범위는 1부터 1000
        long[] cards = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 카드 게임하는 동안
        while (--M >= 0) {
            // 카드를 오름차순 정렬
            Arrays.sort(cards);

            // 가장 작은 두 수를 더한 값을 sum이 참조
            long sum = cards[0] + cards[1];
            // sum이 참조하는 수를 더한 두 카드 cards[0], cards[1]가 또 참조하도록
            cards[1] = sum;
            cards[0] = sum;
        }

        // 정리된 모든 카드를 순회하며 answer에 더해준다.
        long answer = 0;
        for (int i = 0; i < N; i++) {
            answer += cards[i];
        }

        System.out.println(answer);
    }

}
