package Week3.P2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String[] keypad;
    static StringTokenizer st;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("algo_monday/src/Week3/P2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        keypad = new String[10];
        keypad[1] = "1.,?!";
        keypad[2] = "2ABC";
        keypad[3] = "3DEF";
        keypad[4] = "4GHI";
        keypad[5] = "5JKL";
        keypad[6] = "6MNO";
        keypad[7] = "7PQRS";
        keypad[8] = "8TUV";
        keypad[9] = "9WXYZ";

        N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char c = s.charAt(0);
        int cnt = 1;

        for (int i = 1; i < N; i++) {
            if (c != s.charAt(i)) {
                int num = c - '0';
                int len = keypad[num].length();

                cnt = (cnt-1) % len;

                answer.append(keypad[num].charAt(cnt));

                c = s.charAt(i);
                cnt = 1;
            }

            else {
                cnt++;
            }


        }

        if (cnt != 0) {
            int num = c - '0';
            int len = keypad[num].length();

            cnt = (cnt-1) % len;

            answer.append(keypad[num].charAt(cnt));
        }

        System.out.println(answer);
    }


}
