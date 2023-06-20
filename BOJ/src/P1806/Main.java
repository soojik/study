package P1806;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, S;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("BOJ/src/P1806/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    arr = new int[N + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int start = 0;
    int end = 0;
    int sum = arr[start];

    int answer = Integer.MAX_VALUE;

    // end 가 N 보다 작을 때
    while (end < N) {

      // 만약 sum 값이 목표한 S 보다 크거나 같다면 answer 값 및 start 위치의 값 뺀 값으로 sum 갱신
      if (sum >= S) {
        answer = Math.min(answer, end - start + 1);
        sum -= arr[start++];
      }
      // 만약 sum 값이 목표한 S 보다 작다면 end 1 증가 시키며 sum 갱신
      // 여기서 end 가 N 까지 갈 수 있기때문에 기존에 arr 배열을 N+1 만큼으로 크기를 잡아주었다.
      // 그리고 end 가 키워졌다는 뜻은 기존 sum 가 S 보다 작아서이기 떄문에 이상 탐색하지 않아도 답을 구할 수 있다.
      else {
        sum += arr[++end];
      }
    }

    System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
  }
}
