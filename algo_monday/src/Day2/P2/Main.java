package Day2.P2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int len;
    static int answer;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Day2/P2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        len = Integer.parseInt(br.readLine());

        String s = br.readLine();

        char c = ' ';
        answer = 0;
        for (int i = 0; i < len; i++) {
            if (c != s.charAt(i)) {
                c = s.charAt(i);
                answer++;
            }
        }

        System.out.println(answer);
    }
}
