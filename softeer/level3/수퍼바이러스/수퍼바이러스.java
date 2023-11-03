import java.io.*;
import java.util.*;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  static long stol(String s) {return Long.parseLong(s);}
  static int k, p;
  static long n;
  /*
  for 0~n {for 0~10 : k *= p;}
  결국 k*(p^10)^n % 1000000007 ==> k*(p^10n) % 1000000007 를 구하는 문제
  */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    k = stoi(st.nextToken());
    p = stoi(st.nextToken());
    n = stol(st.nextToken()) * 10; // p의 10n 제곱을 구해야하기 때문에 미리 10을 곱해 p^n를 구할 것

    System.out.println(func(n) * k % 1000000007);
  }

  // p^n 을 구하기 위한 메서드
  static long func(long 지수) {
    // 지수가 1이 되면 p 반환
    if (지수 == 1) return p;

    // 그 외에는
    long result;
    // 짝수일 때는 p^(n/2) * p^(n/2) == p^n 가 성립하므로
    if (지수 % 2 == 0) {
      result = func(지수 / 2);
      return result * result % 1000000007;
    }
    // 홀수일 때는 p^(n/2) * p^(n/2) * p == p^n 가 성립하므로
    else {
      result = func((지수 - 1) / 2);
      return (result * result % 1000000007) * p % 1000000007;
    }
  }
}
