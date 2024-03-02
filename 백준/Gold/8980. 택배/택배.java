import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int stoi(String s) {
    return Integer.parseInt(s);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = stoi(st.nextToken());
    int max = stoi(st.nextToken());

    int order_cnt = stoi(br.readLine());

    Delivery[] deliveries = new Delivery[N + 1];

    for (int i = 0; i < order_cnt; i++) {
      st = new StringTokenizer(br.readLine());
      int from = stoi(st.nextToken());
      int to = stoi(st.nextToken());
      int order = stoi(st.nextToken());
      deliveries[i] = new Delivery(from, to, order);
    }

    // i 마을까지 배달할 수 있는 최대 수
    int[] max_deliver = new int[N + 1];
    // 모두 최대 용량으로 초기화
    Arrays.fill(max_deliver, max);

    int ans = 0;

    // 주문 순회
    for (int i = 0; i < order_cnt; i++) {
      Delivery d = deliveries[i];

      int curr_max = max;

      // 현 주문이 거치는 모든 마을을 거치며
      for (int j = d.from; j < d.to; j++) {
        // 차에 보관할 수 있는 택배 개수의 최대를 설정(거친 마을 중 보관 용량이 최소인 곳으로)
        curr_max = Math.min(curr_max, max_deliver[j]);
      }

      // 만약 현재 주문이 남은 용량(curr_max)보다 작거나 같다면(모두 싣기 가능하다면)
      if (d.order <= curr_max) {
        // 거치는 마을의 최대 용량에서 빼주고
        for (int j = d.from; j < d.to; j++) {
          max_deliver[j] -= d.order;
        }
        // 보낼 수 있는 택배 개수 ans에 더해주기
        ans += d.order;
      } else {
        for (int j = d.from; j < d.to; j++) {
          max_deliver[j] -= curr_max;
        }
        ans += curr_max;
      }
    }

    System.out.println(ans);
  }
}

class Delivery implements Comparable<Delivery> {
  int from;
  int to;
  int order;

  public Delivery(int from, int to, int order) {
    this.from = from;
    this.to = to;
    this.order = order;
  }

  @Override
  public int compareTo(Delivery d) {
    if (d.from == this.from) {
      if (d.to == this.to) return d.order - this.order;
      return this.to - d.to;
    }

    return this.from - d.from;
  }

  @Override
  public String toString() {
    return from + " " + to + " " + order;
  }
}