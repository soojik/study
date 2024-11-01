import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    int a_total = 0;
    for (char c : s.toCharArray()) {
      if (c == 'a') ++a_total;
    }

    int len = s.length();
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < len; i++) {
      int cnt = 0;
      for (int j = 0; j < a_total; j++) {
        int idx = (i + j) % len;

        if (s.charAt(idx) == 'b') ++cnt;
      }

      min = Math.min(min, cnt);
    }

    System.out.println(min);
  }
}
