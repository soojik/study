package DAY01.P2003;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAY01/P2003/input.txt"));
        Scanner sc = new Scanner(System.in);

        int answer = 0;

        int N = sc.nextInt();
        int M = sc.nextInt();

        int l = 0;
        int h = 0;

        int[] arr = new int[N];

        for (int i=0;i<N;i++) arr[i] = sc.nextInt();

        int sum = 0;

        while (l < N) {

            if (sum > M || h == N) {
                sum -= arr[l++];
            } else {
                sum += arr[h++];
            }

            if (sum == M) answer++;
        }

        System.out.println(answer);
    }
}
