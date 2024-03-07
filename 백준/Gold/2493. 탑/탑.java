import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 탑 높이, 인덱스
    Stack<int[]> prev = new Stack<>();

    int N = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int curr = Integer.parseInt(st.nextToken());
      // 스택에 값이 있고, 탑의 높이가 현재 높이보다 낮다면 송신 불가능한 탑 
      while (!prev.isEmpty() && prev.peek()[0] < curr) {
        // 뽑아버린다
        prev.pop();
      }

      // 후보 탑들이 안남아있다면 송신가능한 탑이 없단 말이니까 0, 아니면 송신 받을 수 있는 탑 중 가장 가까이 있는 탑(prev.peek())의 인덱스를 출력  
      sb.append((prev.isEmpty()) ? 0 : prev.peek()[1]).append(" ");
      // 현재 탑도 후보 탑에 추가
      prev.add(new int[]{curr, i + 1});
    }

    System.out.println(sb);
  }
}
