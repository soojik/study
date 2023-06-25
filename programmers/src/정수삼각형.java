public class 정수삼각형 {

  public static void main(String[] args) {
    System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
  }

  static int solution(int[][] triangle) {
    int answer = 0;

    int h = triangle.length;
    int w = triangle[h-1].length;
    int[][] dp = new int[h][w];

    dp[0][0] = triangle[0][0];

    for (int i=0;i<h-1;i++) {
      for (int j=0;j<i+1;j++) {
        dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + triangle[i+1][j]);
        dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + triangle[i+1][j+1]);
      }
    }

    for (int i : dp[h-1]) {
      answer = Math.max(i, answer);
    }

    /* stream 공부 해야겠다.
    return Arrays.stream(dp[h-1]).max().getAsInt();
     */
    return answer;
  }
}
