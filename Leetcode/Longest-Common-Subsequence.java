class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
    // 각 문자열에서 인덱스 0에 마진을 넣어서 직전 문자까지의 LCS 검사할 때 인덱스 범위 벗어나지 않도록
    int[][] dp = new int[text1.length()+1][text2.length()+1];

    int ans = 0;
    for (int i=1;i<=text1.length();i++) {
      for (int j=1;j<=text2.length();j++) {
        // 문자가 같다면
        if (text1.charAt(i-1) == text2.charAt(j-1)) {
          // 바로 직전 문자까지의 LCS 길이에서 1(현재 문자까지)을 더해준다.
          dp[i][j] = dp[i-1][j-1] + 1;
        }
        // 다르면
        else {
          // 현재 차례의 문자를 비교하는 직전 단계(i-1번째 문자와 j번째 LCS 길이 dp[i-1][j], i번째 문자와 j-1번째 LCS 길이 dp[i][j-1])를 가져와 더 큰 LCS 길이를 넣어준다.
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
        ans = Math.max(dp[i][j], ans);
      }
    }

    return ans;
  }
}