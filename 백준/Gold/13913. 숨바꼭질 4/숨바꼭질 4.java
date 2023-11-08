import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = stoi(st.nextToken());
    int K = stoi(st.nextToken());

    int[] sec = new int[100001];
    boolean[] visit = new boolean[100001];

    Queue<Integer> q = new LinkedList<>();
    q.add(N);
    visit[N] = true;

    // 직전 위치(인덱스)를 저장할 parent 배열
    int[] parent = new int[100001];

    while (!q.isEmpty()) {

      int curr = q.poll();

      // 현재 위치가 K라면
      if (curr == K) {
        // 걸린 시간 출력
        System.out.println(sec[K]);

        // 지나온 곳을 K부터 거슬러 올라가며 stack 에 쌓아 출력
        Stack<Integer> stack = new Stack<>();
        stack.add(K);
        int index = K;

        while (index != N) {
          stack.add(parent[index]);
          index = parent[index];
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
          sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
        return;
      }

      // 현재 위치가 범위 100000 미만이고 +1 위치에 아직 방문하지 않았다면
      if (curr < 100000 && !visit[curr+1]) {
        // 방문 체크
        visit[curr + 1] = true;
        // 다음 위치에 현재 위치를 직전으로 표시
        parent[curr + 1] = curr;
        // 탐색 계속
        q.add(curr + 1);
        sec[curr + 1] = sec[curr] + 1;
      }
      if (0 < curr && !visit[curr-1]){
        visit[curr - 1] = true;
        parent[curr - 1] = curr;
        q.add(curr - 1);
        sec[curr - 1] = sec[curr] + 1;
      }
      if (curr <= 50000 && !visit[curr * 2]){
        visit[curr * 2] = true;
        parent[curr * 2] = curr;
        q.add(curr * 2);
        sec[curr * 2] = sec[curr] + 1;
      }
    }
  }
}
