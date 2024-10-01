import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N + 1];

    if (N == 1) {
      System.out.println(3);
      return;
    }
    arr[1] = 3;
    arr[2] = 7;
    for (int i = 3; i <= N; i++) {
      arr[i] = (arr[i - 1] * 2 + arr[i - 2]) % 9901;
    }

    System.out.println(arr[N]);
  }
}
