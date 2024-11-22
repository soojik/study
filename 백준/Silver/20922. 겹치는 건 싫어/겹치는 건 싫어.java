import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N, K;
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    int[] numbers = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    int p1 = 0, p2 = 0;
    int max = 0;

    int[] cnt = new int[200001];
    ++cnt[numbers[p1]];

    while (p1 <= p2) {
      if (cnt[numbers[p2]] <= K) {
        ++p2;
        if (p2 == N) {
          max = Math.max(max, p2 - p1);
          break;
        }
        ++cnt[numbers[p2]];
      }

      max = Math.max(max, p2 - p1);
      while (K < cnt[numbers[p2]]) {
        --cnt[numbers[p1++]];
      }
    }

    System.out.println(max);
  }
}
