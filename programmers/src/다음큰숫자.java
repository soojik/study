public class 다음큰숫자 {

  public static void main(String[] args) {

    System.out.println(solution(78));
    System.out.println(solution(15));
    System.out.println(solution(1000000));
  }

  public static int solution(int n) {
    /*
    n 은 최대 1,000,000 이기 때문에
    다음 큰 수 (2진수 변환 후 1의 갯수가 같으며 나보다 큰 수들 중 가장 작은 값) 를 구할 때 제한 시간 1초(약 1억) 가 넘지않을 것이라고 생각되었다.
     */
    int cnt = Integer.bitCount(n);

    while (true) {
      ++n;

      // n 을 2진수로 변환했을 떄 1 갯수 반환
      int new_cnt = Integer.bitCount(n);

      if (cnt == new_cnt) {
        break;
      }
    }

    return n;
  }
}
