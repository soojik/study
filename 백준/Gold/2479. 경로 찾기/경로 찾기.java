import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int N, K;
  static int A, B; // target
  static String[] words;
  static boolean[] visited;
  static int[] parent;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    words = new String[N + 1];
    visited = new boolean[N + 1];
    parent = new int[N + 1];
    for (int i = 1; i <= N; i++) words[i] = br.readLine();

    st = new StringTokenizer(br.readLine());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());

    Queue<Integer> q = new LinkedList<>();
    q.add(A);
    visited[A] = true;

    while (!q.isEmpty()) {
      int curr = q.poll();

      if (curr == B) {
        Stack<Integer> stack = new Stack();
        int i = curr;
        while (i != A) {
          stack.add(i);
          i = parent[i];
        }
        stack.add(A);
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
          sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
        System.exit(0);
      }

      for (int i = 1; i <= N; i++) {
        if (visited[i] || !valid(curr, i)) continue;
        visited[i] = true;
        parent[i] = curr;
        q.add(i);
      }
    }

    System.out.println(-1);
  }

  static boolean valid(int i1, int i2) {
    int result = 0;
    for (int i = 0; i < K; i++) {
      if (words[i1].charAt(i) != words[i2].charAt(i)) ++result;
    }

    return result == 1;
  }
}
