import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
단순하게 생각하면 양수끼리, 음수끼리 절댓값이 큰 순서대로 두개씩 묶어서 더해주면 최댓값을 구할 수 있다.
주의할 점은 0이 있으면 음수 하나가 남아도 상쇄된다는 것, +1는 곱하는것보다 더하는게 더 높은 값이 나온다는 것이다.
 */
public class Main {
  static List<Integer> p_nums = new ArrayList<>();
  static List<Integer> n_nums = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    /* 0이 있는지 확인
    음수가 홀수개라면 절댓값이 가장 작은 음수는 더하지않고 상쇄시키기 위함이므로 0은 유무 정도만 알면 된다.
     */
    boolean isZeroExist = false;

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num < 0) n_nums.add(num);
      else if (0 < num) p_nums.add(num);
      else isZeroExist = true;
    }

    // 절댓값기준 내림차순
    Collections.sort(p_nums, Collections.reverseOrder());
    Collections.sort(n_nums);

    // 만약 양수가 홀수개라면 마지막 숫자는 그냥 ans 에 더해주기
    int ans = 0;
    if (p_nums.size() % 2 == 1) {
      ans += p_nums.remove(p_nums.size() - 1);
    }

    // 짝수개를 맞춰 반복문 
    for (int i = 0; i < p_nums.size(); i += 2) {
      // 두 숫자 중 1이 있으면 둘 다 ans 에 더하고 
      if (p_nums.get(i) == 1 || p_nums.get(i + 1) == 1) {
        ans += p_nums.get(i) + p_nums.get(i + 1);
        continue;
      }
      // 아니면 곱한 값을 더해준가
      ans += p_nums.get(i) * p_nums.get(i + 1);
    }

    // 음수가 홀수만큼 있다면
    if (n_nums.size() % 2 == 1) {
      // 0이 있을 때 마지막 숫자를 그냥 상쇄하고
      if (isZeroExist) n_nums.remove(n_nums.size() - 1);
      // 아니면 더해준다.
      else ans += n_nums.remove(n_nums.size() - 1);
    }

    // 위와 동일하지만 둘 중 -1이 있어도 음수끼리 곱하는 게 낫다.
    for (int i = 0; i < n_nums.size(); i += 2) {
      ans += n_nums.get(i) * n_nums.get(i + 1);
    }

    System.out.println(ans);
  }
}
