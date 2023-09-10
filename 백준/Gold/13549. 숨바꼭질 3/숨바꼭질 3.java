import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
  static int[] dx = {1, -1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Queue<Integer> q = new LinkedList<>();

    // N, K의 최대 100000까지만 방문 여부 탐색
    boolean[] visit = new boolean[100001];
    int[] time = new int[100001];

    q.add(N);

    int answer = Integer.MAX_VALUE;
    while (!q.isEmpty()) {
      int x = q.poll();

      // 목표에 왔다면 계속해서 업데이트 된 time[K] 의 최솟값을 업데이트해준다.
      if (x == K) {
        answer = Math.min(time[K], answer);
      }

      // 현재에서 세가지 상황에 따라 다음 탐색 위치를 q 에 넣어준다.
      // 이때 다음 탐색할 구간이 100000을 넘으면 진행하지 않고, 방문 상황에 따라 최솟값을 업데이트해주거나 첫 방문 프로세스를 거친다.
      // 다음 구간이 100000을 넘는다면 현재보다 나은 경우는 없다.

      // 1. X*2
      if (x * 2 <= 100000) {
        time[x * 2] = time[x];
        // 첫 방문시
        if (!visit[x * 2]) {
          // 방문 체크 후 다음 탐색에 넣어준다. 그리고 다음 구간까지의 시간을 업데이트 해준다.
          visit[x * 2] = true;
          q.add(x * 2);
          time[x * 2] = time[x];
        }
        // 방문한 적 있다면 최솟값 업데이트
        else {
          time[x * 2] = Math.min(time[x * 2], time[x]);
        }
      }

      // 2. X+1 && X-1
      for (int i : dx) {
        if (0 <= x + i && x + i <= 100000) {
          if (!visit[x + i]) {
            visit[x + i] = true;
            q.add(x + i);
            time[x + i] = time[x] + 1;
          }
          else {
            time[x + i] = Math.min(time[x + i], time[x] + 1);
          }
        }
      }
    }

    System.out.println(answer);
  }
}
