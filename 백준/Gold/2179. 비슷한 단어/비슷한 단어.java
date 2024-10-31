import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String[] arr = new String[N];
    for (int i = 0; i < N; i++) {
      arr[i] = br.readLine();
    }

    HashMap<String, Integer> map = new HashMap<>();
    HashMap<Integer, List<int[]>> unit = new HashMap<>();
    int[] answer = new int[2];
    int len_max = 0;

    for (int i = 0; i < N; i++) {
      StringBuffer sb = new StringBuffer();
      for (char c : arr[i].toCharArray()) {
        sb.append(c);
        if (map.containsKey(sb.toString())) {
          if (map.get(sb.toString()) != i && len_max <= sb.length()) {
            len_max = sb.length();
            unit.putIfAbsent(len_max, new ArrayList<>());
            unit.get(len_max).add(new int[]{map.get(sb.toString()), i});
          }
          continue;
        }
        map.put(sb.toString(), i);
      }
    }

    List<int[]> list = unit.get(len_max);
    list.sort((a, b) -> a[0] - b[0]);

    System.out.println(arr[list.get(0)[0]]);
    System.out.println(arr[list.get(0)[1]]);
  }
}
