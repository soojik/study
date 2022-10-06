package P1427;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1427/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int tmp = N;

        while (tmp > 0) {
            list.add(tmp % 10);
            tmp /= 10;
        }

        Collections.sort(list, Collections.reverseOrder());

        for (int i = 0; i < list.size(); i++) {
            answer.append(list.get(i));
        }

        System.out.println(answer);
    }
}
