package P11659;

import java.io.*;
import java.util.StringTokenizer;

// 누적합
// 을 이용한 부분(구간) 합 구하기
public class Main {
  // try ~ catch 문으로 감싸는 것이 더 안전하다는 것을 새로 배웠다!
  // 하지만 코딩 테스트 문제 풀때는 일단 모두 throws로 예외 처리를 하겠다.
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("BOJ/src/P11659/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    // 0 ~ i 까지의 누적합을 저장할 sum_arr 배열
    int[] sum_arr = new int[N];
    sum_arr[0] = Integer.parseInt(st.nextToken());

    // 처음 주어진 수를 입력받을 때부터 sum_arr 배열에 누적합 저장 ; O(N)
    for (int i = 1; i < N; i++) {
      sum_arr[i] += sum_arr[i - 1] + Integer.parseInt(st.nextToken());
    }

    // M 만큼의 테스트 케이스에 대한 정답을 저장할 answer 배열
    int[] answer = new int[M];

    // a 는 시작 위치, b 는 종료 위치
    int a, b;

    // 주어진 테스트 케이스 순회 ; O(M)
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      // 인덱스와 숫자 맞추기
      a = Integer.parseInt(st.nextToken()) - 1;
      b = Integer.parseInt(st.nextToken()) - 1;

      // 시작점(a)이 0이라면 그냥 끝점(b) 까지의 누적합 가져오기
      if (a == 0) {
        answer[i] = sum_arr[b];
      }
      // 시작점(a)이 0이 아니라면 끝점(b) 까지의 누적합에서 시작점(a) 바로 전까지의 누적합의 차 가져오기
      else {
        answer[i] = sum_arr[b] - sum_arr[a - 1];
      }
    }

    // 정답 출력
    for (int i : answer) {
      System.out.println(i);
    }
  }
}
