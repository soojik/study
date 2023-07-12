import java.util.Arrays;

public class 숫자게임 {

  public static void main(String[] args) {
    System.out.println(solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}));
    System.out.println(solution(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1}));
  }

  static int solution(int[] A, int[] B) {
    int answer = 0;

    /*
    A 와 B 모두 오름차순 정렬 후 이 둘을 투포인터로 비교해 문제를 해결했다.
     */

    Arrays.sort(A);
    Arrays.sort(B);

    int len = A.length;

    // pa: a의 포인터
    // pb: b의 포인터
    int pa = 0;
    int pb = 0;
    // pa 랑 pb 중 하나라도 끝에 다다를떄 반복문 종료
    while (pa < len && pb < len) {
      // 만약 A 숫자가 B 숫자보다 크거나 같다면 다음 B 숫자를 비교하기 위해 pb 만 1 증가시켜 준다.
      if (A[pa] >= B[pb]) {
        ++pb;
        continue;
      }
      // B가 A보다 큰 경우는 answer 를 1 증가시키고 B가 이긴다는 조건만 찾으면 되니까 각 다음 A, B 숫자를 비교하도록 했다.
      // 그래서 pa 만 따로 증가시키는 구문은 없다. B 숫자가 A 숫자를 이긴다는 것만 찾으면 되므로
      ++answer;
      ++pa;
      ++pb;
    }

    return answer;
  }
}
