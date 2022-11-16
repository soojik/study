package P2659;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int a,b,c,d;
    static boolean[] visit;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2659/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);
        d = Integer.parseInt(input[3]);

        visit = new boolean[10000];

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        visit[getClockNum(i, j, k, l)] = true;
                    }
                }
            }
        }

        int clockNum = getClockNum(a, b, c, d);
        for (int i = 1111; i <= clockNum; i++) {
            if (visit[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static public int getClockNum(int a, int b, int c, int d) {
        int min = 9999;

        min = Math.min(min, a*1000 + b*100 + c*10 + d);
        min = Math.min(min, b*1000 + c*100 + d*10 + a);
        min = Math.min(min, c*1000 + d*100 + a*10 + b);
        min = Math.min(min, d*1000 + a*100 + b*10 + c);

        return min;
    }

//    static public void getOrderNum() {
//
//    }
}
