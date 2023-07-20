import java.util.stream.LongStream;

public class n2배열자르기 {

  public static void main(String[] args) {

  }

  /*
  n이 최대 10^7, left 와 right 가 최대 n^2 이라서 모든 배열을 채울 순 없었다.
  그래서 이차원 배열을 하나로 만들었을 때를 생각해 [i][i] == [i*n + i] 공식을 이용했다.
  미리 answer 배열을 left ~ right 크기에 맞게 잡아주고
  행은 [i/n], 열은 [i%n] 임을 이용해 문제를 해결할 수 있었다.
  배열[행][열] 에 들어갈 값은 행과 열을 비교해 더 큰 값에 1을 더한 값이다.
   */
  static int[] solution(int n, long left, long right) {
    int len = (int) (right - left + 1);
    int[] answer = new int[len];

    for (long i=left;i<=right;i++) {
      int r = (int) (i / n);
      int c = (int) (i % n);
      int num = Math.max(r, c) + 1;
      answer[(int) (i - left)] = num;
    }

    /* stream 을 이용한 풀이
    return LongStream.rangeClosed(left, right).mapToInt(value -> (int) Math.max(value / n, value % n) + 1).toArray();
    */

    return answer;
  }
}
