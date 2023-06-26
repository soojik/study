import java.util.HashMap;

public class N개의최소공배수 {
  public static void main(String[] args) {
    System.out.println(solution(new int[]{2,6,8,14}));
    System.out.println(solution(new int[]{1,2,3}));
  }

  static int solution(int[] arr) {
    // 각 숫자의 약수들을 구해 약수의 등장횟수가 가장 많은 값으로 업데이트 해주고, answer 에 각 약수의 카운트된 최댓값만큼 곱해줄거라서 1에 저장
    int answer = 1;

    int len = arr.length;
    // 약수: 약수의 최대 등장 횟수
    HashMap<Integer, Integer> cnt = new HashMap<>();

    for (int i=0;i<len;i++) {

      // idx 는 약수, 2부터 시작
      int idx = 2;
      // 더이상 나눌 값이 없을 때까지 (1이 되기 전까지)
      while (arr[i] != 1) {
        // 약수 개수 카운트할 변수
        int idx_cnt = 0;
        // 약수 찾으면
        while (arr[i] % idx == 0) {
          // 해당 약수가 몇번 곱해지는지 카운트할 변수에 1씩 증가시키면서 더이상 해당 약수로 안나눠질 때까지
          ++idx_cnt;
          arr[i] /= idx;
        }
        // idx 약수의 개수가 0 이상일 때
        if (idx_cnt != 0) {
          // cnt 에 idx 약수 최대 등장횟수를 업데이트해준다.
          if (cnt.containsKey(idx)) {
            cnt.put(idx, Math.max(cnt.get(idx), idx_cnt));
          }
          else {
            cnt.put(idx, idx_cnt);
          }
        }
        ++idx;
      }
    }

    // cnt 를 순회하며
    for (int k : cnt.keySet()) {
      int v = cnt.get(k);

      // value 만큼 Key 를 answer 에 곱해준다.
      for (int i=0;i<v;i++) {
        answer *= k;
      }
    }

    return answer;
  }
}
