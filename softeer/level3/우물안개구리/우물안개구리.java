import java.io.*;
import java.util.*;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  static int answer = 0;
  static int N, M;
  static int[] weight;
  static List<Queue<Integer>> compatitions = new ArrayList();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = stoi(st.nextToken());
    int M = stoi(st.nextToken());

    weight = new int[N + 1];
    compatitions.add(new LinkedList());

    st = new StringTokenizer(br.readLine());
    for (int i=1;i<=N;i++) {
      weight[i] = stoi(st.nextToken());
      compatitions.add(new LinkedList());
    }

    for (int i=0;i<M;i++) {
      st = new StringTokenizer(br.readLine());

      int a = stoi(st.nextToken());
      int b = stoi(st.nextToken());

      compatitions.get(a).add(b);
      compatitions.get(b).add(a);
    }

    // 회원 순회
    for (int i=1;i<=N;i++) {
      // 나와 친분이 있는 사람을 순회하며 나보다 무게가 가벼운 사람들은 경쟁자에서 뺀다.
      while (!compatitions.get(i).isEmpty() && weight[compatitions.get(i).peek()] < weight[i]) {
        compatitions.get(i).poll();
      }

      // 나보다 무게가 무거운 사람이 없다면 내가 최고
      if (compatitions.get(i).isEmpty()) ++answer;
    }

    System.out.println(answer);
  }
}
