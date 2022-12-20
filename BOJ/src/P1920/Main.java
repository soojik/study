package P1920;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/src/P1920/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        int[] find_arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            find_arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] found_check = new int[M];

        for (int i = 0; i < M; i++) {
            int find = find_arr[i];

            int s = 0;
            int e = N - 1;

            int mid;
            while (s <= e) {
                mid = (s + e) / 2;

                if (arr[mid] == find) {
                    found_check[i] = 1;
                    break;
                } else if (arr[mid] > find) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
        }

        for (int i : found_check) {
            System.out.println(i);
        }
    }
}
