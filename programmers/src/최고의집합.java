public class 최고의집합 {

  public static void main(String[] args) {

  }

  static int[] solution(int n, int s) {

    int[] answer = new int[n];

    // 집합 크기보다 합이 작으면 자연수로만 채울 수 없기 때문에 -1 반환
    if (n > s) return new int[]{-1};

    /*
    곱했을 때 가장 큰 결과를 내는 경우는 모든 수가 될 수 있는 대로 클때인데 이는 합(s)을 n으로 쪼갠 것과 비슷하다.
    그래서 a 에는 합을 갯수로 나눈 몫이, 나머지는 b에 저장했다.
     */
    int a = s/n;
    int b = s%n;

    // 나머지만큼 1씩 더해줄 것이기 때문에 전체 크기(n) 에서 b 를 뺀 만큼만 몫을 넣어주고
    for (int i=0;i<n - b;i++) {
      answer[i] = a;
    }
    // 나머지는 a 에 1씩 더해서 넣어줬다.
    for (int i=n-b;i<n;i++) {
      answer[i] = a+1;
    }

    return answer;
  }
}
