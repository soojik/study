import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] dist = new int[N];

    for (int i = 1; i < N; i++) {
      dist[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());

    int[] prices = new int[N];
    for (int i = 0; i < N; i++) {
      prices[i] = Integer.parseInt(st.nextToken());
    }

    int lastPrice = prices[0]; // 마지막 주유소의 리터당 가격
    int lastDist = 0; // 마지막으로 주유한 주유소로부터의 누적 거리

    long ans = 0;
    for (int i = 0; i < N; i++) {
      lastDist += dist[i]; // 이동한 거리 추가
      if (prices[i] < lastPrice) { // 만약 현 마을의 주유소 가격이 더 합리적이라면
        ans += (long) lastDist * lastPrice; // 마지막 충전한 주유소로부터의 거리와 그 주유소의 리터당 가격을 곱해 정산
        lastPrice = prices[i]; // 현 마을의 주유소 가격으로 업데이트
        lastDist = 0; // 이동한 거리 0으로 초기화
      }
    }
    ans += (long) lastDist * lastPrice;

    System.out.println(ans);
  }
}
