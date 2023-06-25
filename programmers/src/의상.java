import java.util.HashMap;

public class 의상 {

  public static void main(String[] args) {
    System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    System.out.println(solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
  }

  static int solution(String[][] clothes) {
    int answer = 1;

    // 의상 종류를 Key 로 놓고, value 는 해당 종류의 옷 개수
    HashMap<String, Integer> map = new HashMap<>();

    // clothes 배열 순회하며 map 에 각 의상 수를 종류별로 map 에 카운트 해주었다.
    for (String[] c : clothes) {
      if (map.containsKey(c[1])) {
        map.put(c[1], map.get(c[1])+1);
      }
      else {
        map.put(c[1], 1);
      }
    }

    // map 의 value 를 순회하며
    for (int cnt : map.values()) {
      // cnt + 1를 answer 에 곱해주었다.
      // 항상 모든 종류 옷을 입는것이 아니라서 안입는 선택지도 추가해준다는 의미로 1을 더해 곱해주었다.
      answer *= (cnt + 1);
    }

    // 적어도 1개 이상의 옷은 입기때문에 아예 안입는 선택지를 하나 빼주었다.
    return answer - 1;
  }
}
