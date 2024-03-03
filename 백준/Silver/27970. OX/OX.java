import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String given_str = br.readLine();

    long ans = 0;
    long pow = 1;

    for (char c : given_str.toCharArray()) {
      if (c == 'O') {
        ans += (pow % 1000000007);
        ans %= 1000000007;
      }
      pow *= 2;
      pow %= 1000000007;
    }

    System.out.println(ans % 1000000007);
  }
}