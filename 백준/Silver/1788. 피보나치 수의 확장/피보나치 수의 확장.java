import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] dp_1 = new int[1000001];
    int[] dp_2 = new int[1000001];

    dp_1[1] = 1;
    for (int i = 2; i <= 1000000; i++) {
      dp_1[i] = (dp_1[i - 1] + dp_1[i - 2]) % 1000000000;
    }

    dp_2[1] = 1;
    for (int i = 2; i <= 1000000; i++) {
      dp_2[i] = (dp_2[i - 2] - dp_2[i - 1]) % 1000000000;
    }

    StringBuilder sb = new StringBuilder();
    if (n < 0) sb.append(Integer.compare(dp_2[-1 * n], 0)).append("\n").append(Math.abs(dp_2[-1 * n]));
    else sb.append(dp_1[n] == 0 ? 0 : 1).append("\n").append(dp_1[n]);

    System.out.println(sb);
  }
}
