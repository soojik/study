package P24416;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] arr;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P24416/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[10001];

        answer = new int[2];

        fib(n);
        fibonacci(n);

        sb.append(answer[0]).append(" ").append(answer[1]);
        System.out.println(sb);
    }

    static int fib(int n) {
        if ((n == 1) || (n == 2)) {
            answer[0]++;
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    static void fibonacci(int n) {
        arr[1] = arr[2] = 1;

        for (int i = 3; i <= n; i++) {
            answer[1]++;
            arr[i] = arr[i - 1] + arr[i - 2];
        }
    }
}
