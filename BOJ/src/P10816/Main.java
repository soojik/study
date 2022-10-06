package P10816;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static HashMap<Integer, Integer> cards = new HashMap<>();
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P10816/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());

            if (cards.containsKey(card)) {
                cards.put(card, cards.get(card) + 1);
            } else {
                cards.put(card, 1);
            }
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int card = Integer.parseInt(st.nextToken());

            answer.append(cards.get(card) == null ? 0 : cards.get(card));
            answer.append(" ");
        }

        System.out.println(answer);
    }
}
