import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N, M;
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    Set<String> notepad = new HashSet<>();
    for (int i = 0; i < N; i++) {
      notepad.add(br.readLine());
    }

    StringBuffer sb = new StringBuffer();
    while (M-- > 0) {
      String[] words = br.readLine().split(",");

      for (String w : words) {
        notepad.remove(w);
      }
      sb.append(notepad.size()).append("\n");
    }

    System.out.println(sb);
  }
}
