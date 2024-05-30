import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] cnt = new int[101];
    boolean[] visit = new boolean[101];
    Arrays.fill(cnt, Integer.MAX_VALUE);

    StringTokenizer st = new StringTokenizer(br.readLine());
    // 사다리 수
    int N1 = Integer.parseInt(st.nextToken());
    // 뱀 수
    int N2 = Integer.parseInt(st.nextToken());

    HashMap<Integer, Integer> moveTo = new HashMap<>();

    for (int i = 0; i < N1 + N2; i++) {
      st = new StringTokenizer(br.readLine());
      moveTo.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    // { 칸 번호, 주사위 던진 횟수 }
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{1, 0});

    cnt[1] = 0;
    visit[1] = true;

    while (!q.isEmpty()) {
      int[] curr = q.poll();

      int curr_num = curr[0];
      int depth = curr[1];

      if (curr_num == 100) {
        break;
      }


      int next;
      for (int i = 1; i <= 6; i++) {
        next = curr_num + i;
        if (100 < next) continue;
        if (moveTo.containsKey(next)) {
          q.add(new int[]{moveTo.get(next), depth + 1});
          continue;
        }
        if (depth + 1 < cnt[next]) {
          cnt[next] = Math.min(cnt[next], depth + 1);
          q.add(new int[]{next, depth + 1});
        }
      }
    }

    System.out.println(cnt[100]);
  }
}
