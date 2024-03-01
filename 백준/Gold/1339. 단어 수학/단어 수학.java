import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
알파벳마다 우선순위 큐처럼 alpha_priority(얼마나 우선권이 있는지) 값을 주는데, 한칸씩 뒤로 갈 때마다 10배씩 value를 높여준다.
생각해보면 원리는 AAA + AAA = 2*10^2*A + 2*10^1*A + 2*10^0*A 랑 같다. 
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    String[] given_str = new String[N];
    for (int i = 0; i < N; i++) {
      given_str[i] = new StringBuilder(br.readLine()).reverse().toString();
    }

    // 알파벳의 우선순위를 계산
    // {알파벳, 우선순위}
    HashMap<Character, Integer> alpha_priority = new HashMap<>();
    for (String str : given_str) {
      // 위 예제처럼 자릿수에 맞게 priority를 10씩 늘려가며 더해준다.  
      int priority = 1;
      for (char c : str.toCharArray()) {
        alpha_priority.put(c, alpha_priority.getOrDefault(c, 0) + priority);
        priority *= 10;
      }
    }

    // 우선순위가 큰 알파벳부터 내림차순
    List<Character> alpha_keys = new ArrayList<>(alpha_priority.keySet());

    alpha_keys.sort((o1, o2) -> alpha_priority.get(o2).compareTo(alpha_priority.get(o1)));
    
    int ans = 0;
    // 큰 알파벳부터 9를 곱해서 ans에 더해준다.
    int num = 9;
    for (char alpha : alpha_keys) {
      ans += alpha_priority.get(alpha) * num--;
    }

    System.out.println(ans);
  }
}
