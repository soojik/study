public class 멀리뛰기 {
  public static void main(String[] args) {
    System.out.println(solution(4));
    System.out.println(solution(3));
  }

  static long solution(int n) {
    int[] count = new int[2001];

    count[1] = 1;
    count[2] = 2;

    for (int i=3;i<2000;i++) {
      count[i] = (count[i-1] + count[i-2]) % 1234567;
    }

    return count[n];
  }
}
