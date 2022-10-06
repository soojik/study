package P11399;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P11399/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                answer += arr[j];
            }
        }

        System.out.println(answer);
    }
}
