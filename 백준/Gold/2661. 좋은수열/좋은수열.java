import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static StringBuilder min = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    // min을 나올 수 있는 가장 큰 값으로 초기화해준다.
    min.append("3".repeat(80));

    backtracking(0, new StringBuilder());

    System.out.println(min);
  }

  // 주어진 N만큼 숫자 조합하기
  public static void backtracking(int depth, StringBuilder num) {
    // 좋은 수열인지 판별
    if (!isValid(num)) {
      return;
    }

    if (depth == N) {
      // min 업데이트
      if (num.compareTo(min) < 0) System.out.println(num);
      System.exit(0);
    }

    // 1부터 3까지 순회하며
    for (char c = '1'; c <= '3'; c++) {
      // 직전 값과 같다면 탐색하지 않는다.
      if (num.length() != 0 && num.charAt(num.length()-1) == c) continue;
      // 아니라면 c를 num에 더해주고
      num.append(c);
      // 탐색 진행 후,
      backtracking(depth + 1, num);
      // 다른 길을 탐색하기 위해 방금 붙인 c를 num에서 떼준다.
      num.deleteCharAt(num.length() - 1);
    }
  }

  // 넘어온 num 이 좋은 수열인지 판별하는 메서드
  public static boolean isValid(StringBuilder num) {
    int len = num.length();
    int len_half = len / 2;

    // 기본적으로 1~num길이의 반만큼만 뒤에서부터 판별하며, 같을 경우에는 바로 false 를 반환한다.
    for (int i = 1; i <= len_half; i++) {
      if (num.substring(len - i, len).equals(num.substring(len - i * 2, len - i))) return false;
    }

    return true;
  }
}
