import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int n, m;
  static int[] nums;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    nums = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    // 오름차순 정렬이므로 먼저 배열을 정렬해준다.
    Arrays.sort(nums);

    backtracking(-1, 0, new int[m]);

    bw.flush();
  }

  static void backtracking(int index, int depth, int[] answer) {
    // 배열 채웠으면 출력 후 채우기 종료
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

    // 그 외에는 다음 자신보다 큰 숫자들로 배열을 채운다.
    for (int i = index + 1; i < n; i++) {
      answer[depth] = nums[i];
      backtracking(i, depth + 1, answer);
    }
  }
}
