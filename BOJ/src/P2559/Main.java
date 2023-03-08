package P2559;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("BOJ/src/P2559/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] input_arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      input_arr[i] = Integer.parseInt(st.nextToken());
    }

    int p1 = 0;
    int p2 = K - 1;

    int sum = 0;

    for (int i = 0; i <= p2; i++) {
      sum += input_arr[i];
    }

    int max = sum;
    while (p2 < N - 1) {
      sum -= input_arr[p1++];
      sum += input_arr[++p2];

      max = Math.max(max, sum);
    }

    System.out.println(max);
  }
}
