import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int n, m;
  static int[] arr;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static boolean[] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n];
    visit = new boolean[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    backtracking(0, new int[m]);

    bw.flush();
  }

  static void backtracking(int depth, int[] answer) {
    // 배열이 완성되었다면 출력
    if (depth == m) {
      StringBuilder sb = new StringBuilder();
      for (int i : answer) sb.append(i).append(" ");
      try {
        bw.write(sb.append("\n").toString());
      } catch (IOException e) {
        System.out.println(e.getLocalizedMessage());
      }
      return;
    }

    for (int i = 0; i < n; i++) {
      // 방문 하지 않은 숫자에 대해
      if (!visit[i]) {
        // 방문 체크 후
        visit[i] = true;
        // 배열에 추가하고
        answer[depth] = arr[i];
        // 계속해서 배열 채우기
        backtracking(depth + 1, answer);
        visit[i] = false;
      }
    }
  }
}
