import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  static int[] answer = new int[2];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();
    while (T-- > 0) {
      String W = br.readLine();
      int K = Integer.parseInt(br.readLine());

      answer = new int[]{10001, 0};

      List<Integer>[] positions = new ArrayList[26];
      for (int i = 0; i < 26; i++) {
        positions[i] = new ArrayList<>();
      }
      for (int i = 0; i < W.length(); i++) {
        positions[W.charAt(i) - 'a'].add(i);
      }

      for (int i = 0; i < 26; i++) {
        if (positions[i].size() < K) continue;

        for (int j = 0; j <= positions[i].size() - K; j++) {
          int len = positions[i].get(j + K - 1) - positions[i].get(j) + 1;
          answer[0] = Math.min(answer[0], len);
          answer[1] = Math.max(answer[1], len);
        }
      }

      if (answer[0] == 10001) {
        sb.append(-1).append("\n");
        continue;
      }
      sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
    }

    System.out.println(sb);
  }
}
