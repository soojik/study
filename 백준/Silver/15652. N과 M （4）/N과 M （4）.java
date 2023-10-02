import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n, m;
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    // 배열 만들기
    makeArray(0, new int[m]);
  }

  /*
  depth: answer 배열에 얼마나 채웠는지
  answer: m 만큼의 수를 넣을 배열
   */
  static void makeArray(int depth, int[] answer) {
    // depth 가 m이 되면 배열 채우기 종료
    if (depth == m) {
      // 만들어진 answer 배열 출력
      StringBuilder sb = new StringBuilder();
      for (int i : answer) {
        sb.append(i).append(" ");
      }
      System.out.println(sb);
      return;
    }

    // 만약 배열의 첫번째 값이라면 1부터, 아니라면 직전 숫자부터 차례로 큰값을 넣어준다. 
    for (int i = depth == 0 ? 1 : answer[depth-1]; i <= n; i++) {
      // answer 배열에 다음 값 넣어준 후
      answer[depth] = i;
      // 다음 칸부터 배열 채우기 진행
      makeArray(depth + 1, answer);
    }
  }
}
