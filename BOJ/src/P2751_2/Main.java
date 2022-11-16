package P2751_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] answer;
    static int tmp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P2751_2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        quick_sort(arr, 0, N - 1);

        for (int n : arr) {
            sb.append(n).append("\n");
        }

        System.out.println(sb);
    }

    static public void quick_sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(arr, left, right);

        quick_sort(arr, left, pivot - 1);
        quick_sort(arr, pivot + 1, right);
    }

    static public int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left, j = right;

        while (i < j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (i < j && pivot <= arr[j]) {
                j--;
            }

            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        arr[right] = arr[i];
        arr[i] = pivot;

        return i;
    }
}
