import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    long[] sum = new long[1001];

    int idx = 1, num = 1;
    while (idx <= 1000) {
      for (int i = 0; i < num; i++) {
        if (1000 < idx + i) break;
        sum[idx + i] = sum[idx + i - 1] + num;
      }
      idx += num++;
    }

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    System.out.println(sum[b] - sum[a-1]);
  }
}
