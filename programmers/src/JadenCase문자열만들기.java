import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class JadenCase문자열만들기 {

  public static void main(String[] args) {
    System.out.println(solution("3people unFollowed me"));
    System.out.println(solution("for the last week"));

    System.out.println(solution2("3people unFollowed me"));
    System.out.println(solution2("for the last week"));
  }

  public static String solution(String s) {
    char[] char_arr = s.toCharArray();
    int len = char_arr.length;

    StringBuilder sb = new StringBuilder();

    char now;
    for (int i=0;i<len;i++) {
      now = char_arr[i];
      if (i == 0 || (i != 0 && char_arr[i-1] == ' ')) {
        if (Character.isLetter(now)) {
          sb.append(Character.toUpperCase(now));
          continue;
        }
        sb.append(now);
      }
      else {
        if (Character.isLetter(now)) {
          sb.append(Character.toLowerCase(now));
          continue;
        }
        sb.append(now);
      }
    }

    return sb.toString();
  }

  public static String solution2(String s) {
    StringBuilder answer = new StringBuilder();

    // 알파벳 미리 다 소문자로 바꾸고 String 배열로 변환
    String[] sp = s.toLowerCase().split("");
    // flag 로 첫번째 알파벳인지 판별
    boolean flag = true;

    // String 배열 순회
    for(String ss : sp) {

      // 첫번째에 위치하면 대문자 변환
      answer.append(flag ? ss.toUpperCase() : ss);

      // 바로 전 문자값이 빈칸이어야 true
      flag = ss.equals(" ");
    }

    return answer.toString();
  }
}
