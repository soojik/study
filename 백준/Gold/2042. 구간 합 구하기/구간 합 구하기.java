import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  static long stol(String s) {return Long.parseLong(s);}
  static long[] arr;
  static long[] tree;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = stoi(st.nextToken());
    int M = stoi(st.nextToken()) + stoi(st.nextToken());

    arr = new long[N + 1];

    // 주어지는 값은 모두 int 범위를 넘어선다.
    for (int i = 1; i <= N; i++) {
      arr[i] = stol(br.readLine());
    }

    // segment tree 크기는 N보다 큰 수 중 가장 작은 2의 거듭제곱 수의 제곱이다.
    // {N <= 2^k} ==> {log2(N) <= k}
    // 하지만 N*4 를 하면 모든 트리를 포함할 수 있으므로 일단 이렇게 하자..
    tree = new long[N * 4];

    // 구간합 트리를 채운다.
    init(1, N, 1);

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int cmd1 = stoi(st.nextToken());
      int cmd2 = stoi(st.nextToken());
      long cmd3 = stol(st.nextToken()); // 세번째 값이 수정될 값으로 들어올 수도 있어서 long 타입

      // 첫번째 값이 1이라면 cmd2 에 있는 값을 cmd3으로 업데이트해준다.
      if (cmd1 == 1) {
        update(1, N, cmd2, 1, cmd3 - arr[cmd2]);
        arr[cmd2] = cmd3;
      }
      // 첫번째 값이 2라면 cmd2부터 cmd3까지의 합을 반환한다.
      if (cmd1 == 2) System.out.println(sum(1, N, cmd2, (int) cmd3, 1));
    }
  }

  // start부터 end까지의 합을 tree[node]에 저장하는 트리 초기화 메서드
  static long init(int start, int end, int node) {
    // start와 ㄷnd가 같다면 arr 값을 가져와 넣어준다.
    if (start == end) return tree[node] = arr[start];

    // 그외에는 반을 나누어
    int mid = (start + end) / 2;

    // 다시 트리를 채운다.
    return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
  }

  // left부터 rigth까지의 구간합을 구하는 메서드
  static long sum(int start, int end, int left, int right, int node) {
    // 만약 구하려는 구간이 현재 범위 밖이라면 (right ~ start || end ~ left) 중단
    if (right < start || end < left) return 0;

    // 현재 범위가 구하려는 범위 안이라면 [left ~ start ~ end ~ right) 현재 node의 값을 반환
    if (left <= start && end <= right) return tree[node];

    // 다시 구간을 나눠서 합 구하기
    int mid = (start + end) / 2;

    // 다시 못구한 합구간을 구하러 간다.
    return sum(start, mid, left, right, node * 2) + sum(mid + 1, end, left, right, node * 2 + 1);
  }

  // index 에 있는 수를 diff 만큼 바꿔, 트리의 값도 수정하는 메서드
  static void update(int start, int end, int index, int node, long diff) {
    // 만약 구하려는 구간이 현재 범위 밖이라면 (index ~ start || end ~ index) 중단
    if (index < start || end < index) return;

    // 현재 범위(start ~ end) 안에 index가 있다는 뜻이므로 현재 node도 diff만큼 바꿔준다.
    tree[node] += diff;
    // start와 end가 같다면 중단
    if (start == end) return;

    // 구간나눠 트리 값 수정을 진행
    int mid = (start + end) / 2;

    update(start, mid, index, node * 2, diff);
    update(mid + 1, end, index, node * 2 + 1, diff);
  }
}
