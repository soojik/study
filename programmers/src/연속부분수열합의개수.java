import java.util.HashSet;

public class 연속부분수열합의개수 {

  public static void main(String[] args) {
    System.out.println(solution(new int[]{7, 9, 1, 1, 4}));
  }

  static int solution(int[] elements) {
    // 합을 저장할 HashSet
    HashSet<Integer> sumSet = new HashSet();

    // elements 배열의 요소를 하나씩 방문해서 해당 요소를 기준으로 뒤의 요소를 더해가며 sum 을 set 에 넣어줄 것이다.
    int len = elements.length;
    for (int start=0;start<len;start++) {
      // 기준 요소가 바뀔 때마다 sum 선언 및 0으로 초기화
      int sum = 0;
      // 기준 요소 ~ 기준 요소 직전 까지 배열 순회하며 sum 에 더해서 set 에 넣어준다.
      // 이때 원형수열의 특성상 끝을 만나면 시작으로 돌아갈 수 있기 때문에 방문 인덱스 i 를 기준요소(start) 부터 기준요소 직전(start+len-1) 까지 잡아주었다.
      for (int i=start;i<start+len;i++) {
        sum += elements[i % len];
        sumSet.add(sum);
      }
    }

    return sumSet.size();
  }
}
