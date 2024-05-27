import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static long A;
  static int B, C;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    A = Long.parseLong(st.nextToken()); // A^B % C
    B = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    long ans = 1;
    while (0 < B) {
      if (B % 2 == 1) {
        ans *= A % C;
        ans %= C;
      }

      A *= A % C;
      A %= C;

      B /= 2;
    }
    
    System.out.println(ans);
  }

}
