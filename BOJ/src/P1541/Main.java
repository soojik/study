package P1541;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/src/P1541/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charr = br.readLine().toCharArray();
        List<Integer> num = new ArrayList<>();
        List<Boolean> sign = new ArrayList<>();
        sign.add(true);

        StringBuilder sb = new StringBuilder();
        for (char c : charr) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                num.add(Integer.parseInt(sb.toString()));
                sb = new StringBuilder();
                sign.add((c == '+') ? true : false);
            }
        }

        num.add(Integer.parseInt(sb.toString()));

        int num_len = num.size();

        int sum = 0;
        boolean isMinus = false;
        for (int i = 0; i < num_len; i++) {

            if (sign.get(i)) {
                if (!isMinus) {
                    sum += num.get(i);
                } else {
                    sum -= num.get(i);
                }
            } else {
                isMinus = true;
                sum -= num.get(i);
            }
        }

        System.out.println(sum);

    }
}
