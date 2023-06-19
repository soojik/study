import java.util.Arrays;

public class 카펫 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(10, 2)));
    System.out.println(Arrays.toString(solution(8, 1)));
    System.out.println(Arrays.toString(solution(24, 24)));
  }

  static int[] solution(int brown, int yellow) {

    int[] answer = {};

    /*
     가로: w, 세로: h, 노란색: y, 갈색: b
     (w-2) * (h-2) = y
     hw - 2 * (h + w) + 4 = y
     hw == y + b (전체 타일 수)
     y + b - 2 * (h + w) + 4 = y
     b + 4 = 2 * (h + w);
     y와 b는 상수로 주어져있으니까 hw = y + b 와 위 식을 이용해서 풀면 w, h 를 구할 수 있다.

     이걸 어떤 분은 근의공식을 써서 풀었다..
     */

    int yb = brown + yellow;
    int plus_hw = brown / 2 + 2;

    int h = 0;
    int w;
    while (true) {
      ++h;
      w = plus_hw - h;

      if (yb == w * h) {
        return new int[]{w, h};
      }
    }
  }
}
