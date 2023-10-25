import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  static int N, M;
  static int[] arr;
  static LinkedHashSet<String> set = new LinkedHashSet<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = stoi(st.nextToken());
    M = stoi(st.nextToken());

    arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = stoi(st.nextToken());
    }

    Arrays.sort(arr);

    backtracking(0, 0, new int[M]);

    for (String s : set) {
      System.out.println(s);
    }
  }

  static void backtracking(int index, int depth, int[] answer) {
    if (depth == M) {
      StringBuilder sb = new StringBuilder();
      for (int i : answer) sb.append(i).append(" ");
      set.add(sb.toString());
      return;
    }

    for (int i = index; i < N; i++) {
      answer[depth] = arr[i];
      backtracking(i, depth + 1, answer);
    }
  }
}
