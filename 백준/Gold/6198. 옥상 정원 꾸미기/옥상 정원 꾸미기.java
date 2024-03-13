import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    long ans = 0;

    // 빌딩을 순회하며 i 번째 빌딩을 볼 수 있는 만큼의 빌딩이 쌓인다.
    Stack<Integer> prev = new Stack<>();
    for (int i = 0; i < N; i++) {
      int curr_tower = Integer.parseInt(br.readLine());
      if (prev.isEmpty()) {
        prev.add(curr_tower);
        continue;
      }

      // 이전에 나왔던 빌딩 중 현재보다 같거나 낮은 빌딩은 다 빼기
      while (!prev.isEmpty() && prev.peek() <= curr_tower) {
        prev.pop();
      }

      // 현재 빌딩 꼭대기를 볼 수 있는 빌딩 수
      ans += prev.size();

      // 현재 빌딩 추가
      prev.add(curr_tower);
    }

    System.out.println(ans);
  }
}
