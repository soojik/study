import java.util.Arrays;

public class 이진변환반복하기 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution("110010101001")));
    System.out.println(Arrays.toString(solution("01110")));
    System.out.println(Arrays.toString(solution("1111111")));
  }

  static int[] solution(String s) {

    // [변환 횟수, 제거한 0 개수]
    int[] answer = {0, 0};

    // 최종적으로 "1"만 남을때 까지 이진 변환
    while (s.length() > 1) {

      // 변환 횟수 +1
      ++answer[0];

      // char 자료형으로 돌며 0 또는 1 값 비교
      char[] arr = s.toCharArray();

      // 1 갯수 cnt_1 가 참조하도록
      int cnt_1 = 0;
      for (char c: arr) {
        if (c == '1') ++cnt_1;
      }

      // 가져온 s 문자열의 길이에 1 개수를 빼서 구한 0 개수
      answer[1] += s.length() - cnt_1;

      StringBuilder sb = new StringBuilder();

      // 1만 남은 문자열 길이 == cnt_1
      // 0만 남을때까지 이진변환해서 sb 가 참조하도록
      while (cnt_1 > 0) {
        sb.append(cnt_1 % 2);
        cnt_1 /= 2;
      }

      // 내림차순으로 변환 후 다시 s 가 이를 참조하도록
      s = sb.reverse().toString();
    }

    return answer;
  }
}
