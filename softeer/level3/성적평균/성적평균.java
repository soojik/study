import java.io.*;
import java.util.*;

public class Main {
  static int stoi(String s){return Integer.parseInt(s);}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = stoi(st.nextToken());
    int k = stoi(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] scores = new int[n + 1];

    for (int i=1;i<=n;i++) scores[i] = stoi(st.nextToken());

    int[] sum = new int[n + 1];
    sum[1] = scores[1];
    for (int i=2;i<=n;i++) sum[i] += sum[i-1] + scores[i];

    int answer = 0;
    for (int i=0;i<k;i++) {
      st = new StringTokenizer(br.readLine());

      int start = stoi(st.nextToken());
      int end = stoi(st.nextToken());

      answer = sum[end] - sum[start - 1];

      System.out.printf("%.2f", ((double) answer) / (end - start + 1));
      System.out.println();
    }
  }
}
