package P9663;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static int[] queen;
  static int answer = 0;
  /*
  N * N 크기의 체스판이 주어지고, 여기에 퀸 N 개를 놓을 때, 서로가 공격받지 않는 경우의 수를 구하는 문제이다.
  퀸은 가로, 세로, 대각선으로 움직인다고 하니까, 결국 각 퀸들은 행과 열이 겹치면 안된다.
  이 성질을 이용해 배열은 1차원 배열로 두며 각 인덱스를 행(또는 열)로, 해당 인덱스의 값은 열(또는 행) 으로 둘 수 있다.
   */

  public static void main(String[] args) {
    try {
      System.setIn(new FileInputStream("BOJ/src/P9663/input.txt"));
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      N = Integer.parseInt(br.readLine());

      /*
      퀸의 자리를 표시할 배열
       */
      queen = new int[N];

      dfs(0);

      System.out.println(answer);

    } catch (IOException e) {
      System.out.println(e.getLocalizedMessage());
    }
  }

  // 깊이우선탐색 알고리즘을 이용해 depth 로 이제까지 몇개의 퀸을 뛌는지 체크
  // 위에서 말했듯 퀸은 행과 열이 겹치면 안되기 때문에 0 ~ N-1 행을 차레로 순회(depth)하며 배열에 각 행에 몇 열에 퀸이 있는지 queen 배열에 열로서 체크해줄 것이다.
  static void dfs(int depth) {

    // 퀸 수가 N 과 같아지면 (행을 모두 체크했다면) dfs 종료
    if (depth == N) {
      answer++;
      return;
    }

    // depth 행에서 열을 순회(i)하며 queen 에 표시해주고
    for (int i = 0; i < N; i++) {
      queen[depth] = i;

      // check_queen 메서드로 다른 퀸에 방해받지 않는지 체크
      if (check_queen(depth)) {
        dfs(depth + 1);
      }
    }
  }

  static boolean check_queen(int x) {
    // 주어진 행(x)을 이용해 이전 행을 검사해
    for (int i = 0; i < y; i++) {
      // 같은 열에 존재하는지 확인
      if (queen[i] == queen[y]) {
        return false;
      }

      // 현재 열보다 이전의 퀸의 대각선에 위치하는지 확인
      else if ((Math.abs(y - i) == Math.abs(queen[y] - queen[i]))) {
        return false;
      }
    }

    // 이외에 같은 행에 존재하는 경우는 이미 배열을 1차원으로 만들면서 방지했기 때문에 패스한다.

    return true;
  }
}
