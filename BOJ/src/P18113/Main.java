package P18113;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int N, K, M;
  static List<Integer> kb;

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("BOJ/src/P18113/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    kb = new ArrayList<>();

    int size_tmp;
    int max = 0;
    for (int i = 0; i < N; i++) {
      size_tmp = Integer.parseInt(br.readLine());
      if (size_tmp >= 2 * K) {
        size_tmp -= 2 * K;
      } else if (size_tmp > K) {
        size_tmp -= K;
      } else {
        continue;
      }

      kb.add(size_tmp);

      max = Math.max(max, size_tmp);
    }

    // max가 여전히 0이라는 뜻은 손질된 김밥 모두 길이가 0이거나 폐기되었다는 뜻이므로 바로 -1 출력하고 끝
    if (max == 0) {
      System.out.println(-1);
      return;
    }

    int answer = BS(1, max + 1) - 1;
    // 이분탐색 결과가 0 이라는 것은 나눌 수 있는 길이가 없다는 뜻이므로 -1 출력하도록 함
    System.out.println((answer > 0) ? answer : -1);
  }

  // 자를 수 있는 김밥 크기의 범위 start ~ end 를 입력받아서
  // 그 사이에 적절한 크기로 나눌 수 있는지 김밥 배열 순회하며 확인하는 이분탐색 이용할 메서드
  // upperbound 형태로 원하는 M 만큼의
  static int BS(int start, int end) {

    int mid;

    int list_size = kb.size();

    while (start < end) {

      mid = (start + end) / 2;

      int cnt_piece = 0;

      // 손질된 김밥 배열 순회하며 현재 mid 크기만큼 김밥을 잘라 cnt_piece에 더해준다.
      for (int i = 0; i < list_size; i++) {
        cnt_piece += kb.get(i) / mid;
      }

      // mid 크기만큼 잘라 정리한 김밥 조각의 갯수가 원하는 M보다 크거나 같다면
      if (cnt_piece >= M) {
        start = mid + 1;
      }
      else {
        end = mid;
      }

    }

    return (start + end) / 2;
  }
}
