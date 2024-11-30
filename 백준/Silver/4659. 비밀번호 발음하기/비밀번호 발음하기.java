import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String word = "";
    Set<Character> set = new HashSet<>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');
    while (!(word = br.readLine()).equals("end")) {
      // 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
      boolean check1 = false;
      // 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
      boolean check2 = true;
      // 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
      boolean check3 = true;

      StringBuffer sb = new StringBuffer();
      for (char c : word.toCharArray()) {
        if (!check1 && set.contains(c)) {check1 = true;}
        if (3 <= sb.length()) {
          sb.deleteCharAt(0);
        }
        sb.append(c);
        if (sb.length() < 3) continue;

        int cnt = 0;
        for (char c1 : sb.toString().toCharArray()) {
          if (set.contains(c1)) {++cnt;}
        }
        if (cnt == 3 || cnt == 0) {
          check2 = false;
        }
      }

      for (int i = 0; i < word.length()-1; i++) {
        if (word.charAt(i) == 'e' || word.charAt(i) == 'o') continue;
        if (word.charAt(i) == word.charAt(i+1)) {
          check3 = false;
          break;
        }
      }

      if (check1 && check2 && check3) {
        System.out.printf("<%s> is acceptable.", word).println();
        continue;
      }
      System.out.printf("<%s> is not acceptable.", word).println();
    }
  }
}
