import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  static int N, M;
  static int[][] map;
  static List<int[]> chickens = new ArrayList<>(); // 모든 치킨집 위치 
  static List<int[]> houses = new ArrayList<>(); // 모든 일반집 위치
  static int chickens_len; // 치킨집 수
  static int answer = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = stoi(st.nextToken());
    M = stoi(st.nextToken());

    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = stoi(st.nextToken());
        if (map[i][j] == 2) chickens.add(new int[]{i, j});
        else if (map[i][j] == 1) houses.add(new int[]{i, j});
      }
    }

    chickens_len = chickens.size();

    makeCombs(new int[M][2], -1, 0);

    System.out.println(answer);

  }

  // M개의 치킨집을 이룰 수 있는 모든 조합을 찾아낸다.
  static void makeCombs(int[][] comb, int index, int depth) {
    // M개를 다 찾았다면
    if (depth == M) {
      // 해당 조합에 대한 치킨 거리를 구한다.
      getChickenDistance(comb);
      return;
    }

    // M개의 치킨집 조합을 만든다.
    for (int i = index + 1; i < chickens_len; i++) {
      comb[depth] = chickens.get(i);
      makeCombs(comb, i, depth + 1);
    }
  }

  // 들어온 comb 조합에 대한 치킨 거리를 구한다.
  static void getChickenDistance(int[][] comb) {
    int sum = 0;
    // 모든 집을 순회하며
    for (int[] h : houses) {
      // 조합 안에 있는 치킨집 중 가장 가까운 치킨 집까지의 거리(min)를 구한다.
      int min = Integer.MAX_VALUE;
      for (int[] c : comb) {
        min = Math.min(Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]), min);
      }
      // 구한 min을 sum에 더해준다.
      sum += min;
    }

    // answer를 최솟값으로 업데이트해준다.
    answer = Math.min(sum, answer);
  }
}
