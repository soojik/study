import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = stoi(st.nextToken());
    int K = stoi(st.nextToken());

    int[] coin = new int[N];
    for (int i = 0; i < N; i++) {
      coin[i] = stoi(br.readLine());
    }

    int[] dp = new int[K + 1];
    dp[0] = 1;

    // 모든 동전 순회하며
    for (int c : coin) {
      // 1부터 K까지 각 총액을 맞추기 위해 사용되는 동전
      for (int i = 1; i <= K; i++) {
        // 인덱스를 벗어나면 체크 안함
        if (i-c<0) continue;
        // i원을 맞추기 위해 c를 하나씩 뺐을 때 경우들을 더해준다.  
        dp[i] += dp[i - c];
      }
    }

    System.out.println(dp[K]);
  }
}
