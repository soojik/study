import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int N, K;
  static String table;
  static Queue<Integer> persons = new LinkedList<>();
  static Queue<Integer> hamburgers = new LinkedList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    table = br.readLine();

    for (int i = 0; i < N; i++) {
      if (table.charAt(i) == 'H') {
        hamburgers.add(i);
        continue;
      }
      persons.add(i);
    }

    int answer = 0;

    int p, h;
    while (!persons.isEmpty()) {
      p = persons.poll();

      while (!hamburgers.isEmpty()) {
        if (p + K < hamburgers.peek()) {
          break;
        }

        h = hamburgers.poll();

        if (p - K <= h && h <= p + K) {
          ++answer;
          break;
        }
      }
    }

    System.out.println(answer);
  }
}
