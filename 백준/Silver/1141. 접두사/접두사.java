import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
  static int N;
  static String[] words;
  static Set<String> set = new HashSet<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    words = new String[N];
    for (int i = 0; i < N; i++) {
      words[i] = br.readLine();
    }

    Arrays.sort(words, (a, b) -> b.length() - a.length());

    for (String word : words) {
      if (isValid(word)) {
        set.add(word);
      }
    }

    System.out.println(set.size());
  }

  static boolean isValid(String word) {
    for (String s : set) {
      if (s.startsWith(word)) return false;
    }

    return true;
  }
}
