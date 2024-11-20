import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    if (N + 1 < a + b) {
      System.out.println(-1);
      return;
    }

    List<Integer> list = new ArrayList<>();

    int max = N;

    for (int i = 1; i <= a - 1; i++) {
      list.add(i);
    }

    list.add(Math.max(a, b));

    for (int i = b - 1; i >= 1; i--) {
      list.add(i);
    }

    if (a == 1) {
      while (list.size() < N) {
        list.add(1, 1);
      }
    } else {
      while (list.size() < N) {
        list.add(0, 1);
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int l : list) {
      sb.append(l).append(" ");
    }

    System.out.println(sb);
  }
}
