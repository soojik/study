import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N, D, K, C;
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
    N = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    int[] sushies = new int[N];
    for(int i=0; i<N; i++) {
      sushies[i] = Integer.parseInt(br.readLine());
    }

    int max = 0;

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < K; i++) {
      map.put(sushies[i], map.getOrDefault(sushies[i], 0) + 1);
    }

    int p = K;
    while (p != K - 1) {
      max = Math.max(max, map.containsKey(C) ? map.size() : map.size() + 1);
      int idx = p - K < 0 ? p - K + N : p - K;
      map.put(sushies[idx], map.get(sushies[idx]) - 1);
      if (map.get(sushies[idx]) == 0) map.remove(sushies[idx]);
      map.put(sushies[p], map.getOrDefault(sushies[p], 0) + 1);

      ++p;
      p = N <= p ? p - N : p;
    }

    System.out.println(Math.max(max, map.containsKey(C) ? map.size() : map.size() + 1));
  }
}
