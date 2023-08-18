import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

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

    Arrays.sort(jewels);

    int[] bags = new int[K];

    for (int i = 0; i < K; i++) {
      bags[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(bags);

    int p = 0;
    long sum = 0;
    PriorityQueue<Jewel> pq = new PriorityQueue<>(Comparator.comparingInt(Jewel::getV).reversed());
    for (int bag : bags) {
      while (p < N) {
        if (jewels[p].M > bag) {
          break;
        }
        pq.add(jewels[p++]);
      }

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