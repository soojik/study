import java.io.*;
import java.util.*;

public class Main {
  static int n, m;
  static int[] nums;
  // 중복된 순열 있는지 확인하기 위한 HashSet
  static LinkedHashSet<String> sets = new LinkedHashSet<>();
  static boolean[] visit;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    nums = new int[n];
    visit = new boolean[n];

    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(nums);

    backtracking(0, new int[m]);

    for (String str : sets) {
      System.out.println(str);
    }
  }

  static void backtracking(int depth, int[] answer) {
    if (depth == m) {
      // 한번 나왔던 배열이라면 출력 및 탐색 종료
      // 그 외에는 sets 에 넣어주고 출력
      StringBuilder sb = new StringBuilder();
      for (int i : answer) sb.append(i).append(' ');
      if (sets.contains(sb.toString())) return;
      sets.add(sb.toString());
      return;
    }

    for (int i = 0; i < n; i++) {
      if (visit[i]) continue;
      visit[i] = true;
      answer[depth] = nums[i];
      backtracking(depth + 1, answer);
      visit[i] = false;
    }
  }
}
