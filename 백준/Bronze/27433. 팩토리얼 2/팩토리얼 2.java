import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println(factorial(Long.parseLong(br.readLine())));
  }

  static long factorial(long n) {
    if (n == 0 || n == 1) return 1;
    return n * factorial(n - 1);
  }
}
