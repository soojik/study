import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Map<Character, Integer> map = new HashMap<>();
    map.put('Y', 2);
    map.put('F', 3);
    map.put('O', 4);

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    char game = st.nextToken().charAt(0);

    Set<String> names = new HashSet<>();
    for (int i = 0; i < N; i++) {
      names.add(br.readLine());
    }

    System.out.println(names.size() / (map.get(game) - 1));
  }
}
