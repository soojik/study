import java.util.HashMap;

public class 할인행사 {=
  static HashMap<String, Integer> map = new HashMap();

  public static void main(String[] args) {
    System.out.println(solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
    System.out.println(solution(new String[]{"apple"}, new int[10], new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));
  }

  static int solution(String[] want, int[] number, String[] discount) {
    int answer = 0;

    int len = want.length;

    // 모든 want 목록을 map 에 <상품명, 필요한 개수> 로 넣어준다.
    // discount 을 순회하며 살 수 있는 품목을 map 에서 체크하며 하나씩 감소시켜준다.
    // 투포인터랑 비슷한 형태로 앞과 뒤를 하나씩 뒤로 땡기며 map 에 체크해준다.
    for (int i=0;i<len;i++) {
      map.put(want[i], number[i]);
    }

    // 먼저 앞 10일간의 할인 품목을 체크해주고,
    for (int i=0;i<10;i++) {
      if (map.containsKey(discount[i])) {
        map.put(discount[i], map.get(discount[i]) - 1);
      }
    }

    // 모든 품목을 원하는 만큼 얻으면 answer 에 1 증가
    if (check()) ++answer;

    // 남은 discount 순회
    int discount_len = discount.length;
    for (int i=10;i<discount_len;i++) {
      // 앞 포인터를 하나 땡기며 거기 있던 폼목에 대해서는 빠졌으니 map 에서 key 있는지 확인후 있다면, value(필요한 개수) 를 1만큼 증가
      if (map.containsKey(discount[i - 10])) map.put(discount[i - 10], map.get(discount[i - 10]) + 1);
      // 뒤 포인터를 하나 땡기며 필요한 물품인지 확인 후, 있다면 1 감소
      if (map.containsKey(discount[i])) map.put(discount[i], map.get(discount[i]) - 1);
      // 새롭게 갱신된 map 을 검사
      if (check()) ++answer;
    }

    return answer;
  }

  // 원하는 품목을 모두 얻었으면 모든 value 가 0 이기때문에 그 경우만 true 를 반환하도록
  static boolean check() {
    for (String product : map.keySet()) {
      if (map.get(product) != 0) {
        return false;
      }
    }

    return true;
  }
}
