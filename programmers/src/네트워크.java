public class 네트워크 {

  static boolean[][] visit;
  static int size;
  public static void main(String[] args) {
    System.out.println(solution(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, 3));
    System.out.println(solution(new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}, 3));
  }

  static int solution(int[][] computers, int n) {
    int answer = 0;
    size = computers.length;
    // computers 에 대응하는 방문 배열
    visit = new boolean[n][n];

    // 각 computers[from][to] 연결상태 및 방문 체크
    for (int i=0;i<size;i++) {
      for (int j=0;j<size;j++) {
        // 방문했거나 이어지지 않았다면 탐색 진행하지 않도록
        if (visit[i][j] || computers[i][j] == 0) continue;
        // 그 이외의 경우
        // 방문 체크 후
        visit[i][j] = true;
        // 방문하지 않았다면 answer(네트워크 개수) 1 증가
        ++answer;

        // 각 컴퓨터 방문 체크
        dfs(computers, j);
      }
    }

    return answer;
  }

  // computers[i][j] 연결에 대한 방문 체크 할 dfs 메서드
  static void dfs(int[][] computers, int to) {
    for (int i=0;i<size;i++) {
      // 방문했거나 이어지지 않은 곳이면 넘어가기
      if (computers[to][i] == 0 || visit[to][i]) continue;

      // 방문 체크 후
      visit[to][i] = true;

      // 해당하는 다음 컴퓨터 탐색
      dfs(computers, i);
    }
  }
}
