import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  static List<LinkedHashSet<String>> combi = new ArrayList<>(); // 각 테스트케이스의 조합을 모아둘 list
  static int N;
  static int[] nums;
  static int idx = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = stoi(st.nextToken());
      if (N == 0) return;

      nums = new int[N];
      combi.add(new LinkedHashSet<>());

      for (int i = 0; i < N; i++) nums[i] = stoi(st.nextToken());

      backtracking(-1, 0, new int[6]);

      // 테스트케이스 사이에 한칸을 띄우기 위함 
      if (!(idx == 0)) System.out.println();

      for (String s : combi.get(idx)) {
        System.out.println(s);
      }

      ++idx;
    }
  }

  // 오름차순으로 모든 조합 찾아서 테스트케이스 차례에 맞게 combi에 넣어준다.
  static void backtracking (int index, int depth, int[] arr) {
    if (depth == 6) {
      StringBuilder sb = new StringBuilder();
      for (int i : arr) sb.append(i).append(" ");
      combi.get(idx).add(sb.toString());
      return;
    }

    for (int i = index + 1; i < N; i++) {
      arr[depth] = nums[i];
      backtracking(i, depth + 1, arr);
    }
  }
}
