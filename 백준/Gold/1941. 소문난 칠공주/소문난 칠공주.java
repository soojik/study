import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int answer = 0;
  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};
  static int[][] seats = new int[25][2]; // 0부터 24번 자리의 각 위치[r, c]를 담은 배열
  static int[] combi = new int[7]; // 0~24번 중 무작위로 7개의 숫자를 뽑아 조합을 만들어 저장할 combi
  static boolean[][] seatS; // 자리(위치)가 다솜파라면 true
  /*
  먼저 25개의 자리에 0~24까지 번호를 붙여서 7개를 뽑는다.
  이 번호(자리)들이 붙어있는지 확인해서 모두 붙어있고, 다솜파가 4명 이상이라면 answer 에 1을 더해주는 방식 
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 자리가 다솜파라면 true, 도연파라면 false
    seatS = new boolean[5][5];

    for (int i = 0; i < 5; i++) {
      String input_str = br.readLine();
      for (int j = 0; j < 5; j++) {
        seatS[i][j] = input_str.charAt(j) == 'S';
        seats[i * 5 + j] = new int[]{i, j};
      }
    }

    // 조합 구하기
    combination(0, 0);

    // 나올 수 있는 조합의 수를 출력
    System.out.println(answer);
  }

  static void combination(int index, int depth) {
    // 7개가 모두 채워졌다면, 만들어진 combi를 대상으로 자리가 붙어있는지 확인한다.
    if (index == 7) {
      isValid();
      return;
    }

    // 24번까지 모두 조합을 만들었다면 종료
    if (depth == 25) return;

    combi[index] = depth;
    combination(index + 1, depth + 1); // depth 를 조합에 넣은 경우
    combination(index, depth + 1); // depth 를 조합에 안넣은 경우
  }

  // combi 를 대상으로 자리들이 붙어있는지 확인
  static void isValid() {
    Queue<Integer> q = new LinkedList<>();
    boolean[] visit = new boolean[7];

    q.add(combi[0]);
    visit[0] = true;

    // 다솜파와 도연파의 수
    int cntS = 0, cntY = 0;
    while (!q.isEmpty()) {
      int curr = q.poll();
      // 현재 번호(curr)의 실제 위치[r,c]
      int cr = seats[curr][0];
      int cc = seats[curr][1];
      
      if (seatS[cr][cc]) ++cntS;
      else ++cntY;

      for (int i = 0; i < 4; i++) {
        int nr = cr + dr[i];
        int nc = cc + dc[i];

        for (int j = 1; j < 7; j++) {
          if (!visit[j] && seats[combi[j]][0] == nr && seats[combi[j]][1] == nc) {
            visit[j] = true;
            q.add(combi[j]);
          }
        }
      }
    }

    // 1. 모두 붙어있고, 다솜파가 4명 이상이면 answer 1 증가 
    if (cntS + cntY == 7 && cntS >= 4) ++answer;
  }
}