package P15650;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] arr;
  static boolean[] visit;
  static int N, M;
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("BOJ/src/P15649/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M];
    visit = new boolean[N];

    DFS(0);
  }

  static void DFS(int depth) {
    if (depth == M) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < M; i++) {
        sb.append(arr[i]).append(" ");
      }
      System.out.println(sb);
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visit[i]) {
        visit[i] = true;
        arr[depth] = i + 1;
        if (depth == 0) {
          DFS(depth + 1);
        } else if (arr[depth - 1] < arr[depth]) {
          DFS(depth + 1);
        }
        visit[i] = false;
      }
    }
  }
}
