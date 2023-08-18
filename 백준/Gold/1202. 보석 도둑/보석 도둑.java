import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Jewel[] jewels = new Jewel[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    // 보석을 무게순으로 오름차순 정렬
    Arrays.sort(jewels);

    int[] bags = new int[K];

    for (int i = 0; i < K; i++) {
      bags[i] = Integer.parseInt(br.readLine());
    }

    // 가방도 최대 무게순으로 오름차순 정렬
    Arrays.sort(bags);

    /*
    bags(가방 배열)을 순회하며
    jewels(보석 배열)을 동시에 순회하는데, 현재 가리키는 가방(bag)보다 작은 값들은 모두 우선순위에 넣고,
    큰 값을 만나면 넣을 수 있는 보석순회를 멈추고 현재 우선순휘 큐에 가장 앞에 있는 보석을 꺼내 정답 변수(sum)에 더해준다.     
     */
    // 보석 순회할 때 쓴 포인터
    int p = 0;
    long sum = 0;
    // 우선순위 큐는 가격에 대해 내림차순으로 정렬한다.
    PriorityQueue<Jewel> pq = new PriorityQueue<>(Comparator.comparingInt(Jewel::getV).reversed());
    for (int bag : bags) {
      // p가 배열 범위 벗어나기 전까지
      while (p < N) {
        // 현재 가리키는 가방보다 보석 무게가 더 크다면
        if (jewels[p].M > bag) {
          // 넣을 수 있는 보석 탐색 멈추기
          break;
        }
        // 보석을 넣을 수 있다면 우선순위 큐에 넣어준다.
        pq.add(jewels[p++]);
      }

      // 넣을 수 있는 보석 중 가장 큰 값을 가진 보석, 가장 앞에 있는 객체 꺼내서 sum 에 더해준다. 
      if (!pq.isEmpty()) sum += pq.poll().V;
    }

    System.out.println(sum);
  }
}

class Jewel implements Comparable<Jewel> {
  int M;
  int V;

  public Jewel(int m, int v) {
    M = m;
    V = v;
  }

  // 무게에 대한 오름차순 
  @Override
  public int compareTo(Jewel j) {
    return this.M - j.M;
  }

  public int getM() {
    return M;
  }

  public int getV() {
    return V;
  }
}