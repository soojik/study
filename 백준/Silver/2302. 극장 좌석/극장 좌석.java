import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  static int stoi(String s) {return  Integer.parseInt(s);}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = stoi(br.readLine());
    int M = stoi(br.readLine());

    int[] dp = new int[41];

    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;

    // vip가 없다는 가정 하에 i크기의 연석의 경우의 수
    for (int i = 3; i <= N; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    // vip자리 순회하며 vip를 제외한 자리의 모든 연석에 대한 경우의 수를 곱해준다.
    int answer = 1;
    int lastVip = 0;
    for (int i = 0; i < M; i++) {
      int vip = stoi(br.readLine());
      answer *= dp[vip - lastVip - 1];

      lastVip = vip;
    }

    // 마지막 vip석부터 끝자리까지
    answer *= dp[N - lastVip];

    System.out.println(answer);
  }
}
