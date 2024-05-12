import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
N 은 짝수
 */
public class Main {
  static int N;
  static int[][] score;
  static int min = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    score = new int[N][N];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        score[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    func(0, new int[N / 2], new int[N / 2], 0, 0);

    System.out.println(min);

  }

  /**
   * idx: 검사할 선수 번호
   * team1: team1 선수 목록
   * team2: team2 선수 목록
   * depth1: team1 몇명째 영입?
   * depth2: team2 몇명째 영입?
   */
  static void func(int idx, int[] team1, int[] team2, int depth1, int depth2) {
    if (idx == N) {
      min = Math.min(min, Math.abs(getSum(team1) - getSum(team2)));
      return;
    }

    if (depth1 < N/2) {
      team1[depth1] = idx;
      func(idx + 1, team1, team2, depth1 + 1, depth2);
      team1[depth1] = 0;
    }
    if (depth2 < N/2) {
      team2[depth2] = idx;
      func(idx + 1, team1, team2, depth1, depth2 + 1);
      team2[depth2] = 0;
    }
  }

  static int getSum(int[] team) {
    int sum = 0;
    for (int i = 0; i < team.length; i++) {
      for (int j = 0; j < team.length; j++) {
        sum += score[team[i]][team[j]];
      }
    }

    return sum;
  }
}
