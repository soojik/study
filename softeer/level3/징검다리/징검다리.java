import java.io.*;
import java.util.*;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = stoi(br.readLine());

    int[] arr = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i=0;i<n;i++) arr[i] = stoi(st.nextToken());

    // i번째 돌을 포함한 밟아온 돌 개수
    int[] 밟아온돌개수 = new int[n];

    // 0부터 도착지 직전 돌까지를 시작점으로
    for (int i=0;i<n-1;i++) {
      // 시작점(i) 뒤에 있는 돌을 순회하며
      for (int j=i+1;j<n;j++) {
        // 높으면서 시작점까지 밟아온 돌 개수가 같거나 크다면
        // i까지 밟아온 돌 개수에서 1을 더한 값으로 j인덱스 값을 업데이트 해준다.
        if (arr[i] < arr[j] && 밟아온돌개수[i] >= 밟아온돌개수[j]) 밟아온돌개수[j] = 밟아온돌개수[i] + 1;
      }
    }

    // 가장 큰 값이 가장 많은 돌을 밟은 경우
    int max = 0;
    for (int i=0;i<n;i++) max = Math.max(max, 밟아온돌개수[i]);

    System.out.println(max + 1);
  }
}
