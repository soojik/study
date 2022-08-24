package P2331;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int A, P;
    static List<Integer> list;
    static int tmp, sum;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2331/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        list.add(A);
        while (true) {
            tmp = list.get(list.size()-1);

            sum = 0;
            while (tmp != 0) {
                sum += Math.pow(tmp % 10, P);
                tmp /= 10;
            }

            if (list.contains(sum)) {
                System.out.println(list.indexOf(sum));
                break;
            }

            list.add(sum);
        }
    }
}
