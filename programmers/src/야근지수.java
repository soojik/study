import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class 야근지수 {

  public static void main(String[] args) {
    System.out.println(solution(4, new int[]{4, 3, 3}));
    System.out.println(solution(1, new int[]{2, 1, 2}));
    System.out.println(solution(3, new int[]{1, 1}));
  }

  /*
  야근 피로도는 야근을 시작한 시점부터 남은 일의 작업량의 제곱을 모두 더한 값
  그러므로 제곱되는 수(각 남은 작업량) 을 최소한으로 줄여야한다.
  야근까지 남은 시간만큼 PriorityQueue 를 이용해서 가장 큰 작업량부터 꺼내어 하나씩 줄여준다.
   */
  static long solution(int n, int[] works) {
    long answer = 0;

    // 가장 큰 수부터 꺼내기 위해 PriorityQueue 를 내림차순으로 바꿔준다.
    PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
    // works 값을 모두 queue 에 넣어준다.
    q.addAll(Arrays.stream(works)
            .boxed()
            .collect(Collectors.toList()));

    for (int i=0;i<n;i++) {
      // 만약 q 가 비었다면 잔업이 없다는 말이니까 0을 반환한다.
      if (q.isEmpty()) return 0;

      // 그 이외에는 queue 에서 가장 앞에 있는 값을 꺼내준다.
      int biggestLeft = q.poll();

      // 남은 작업 중 가장 오래 걸리는 일(biggestLeft)이 1일때는 따로 queue 에 다시 넣어주지 않는다.
      if (biggestLeft == 1) continue;

      // 그 이외의 경우에는 1 감소 후 queue 에 넣어준다.
      q.add(biggestLeft - 1);
    }

    // q 에 남은 값을 각 제곱하여 answer 에 더해준다.
    for (int leftWork : q) {
      answer += leftWork * leftWork;
    }

    return answer;
  }
}
