package P2751;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2751/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        while (!valid()) {
            bubble();
        }

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bubble() {
        int tmp;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                tmp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = tmp;
            }
        }
    }

    public static boolean valid() {
        boolean result = true;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                result = false;
                break;
            }
        }

        return result;
    }
}
