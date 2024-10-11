class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int len = triangle.length;
        int[][] dp = new int[len + 1][len + 1];
        
        for (int i=0;i<len;i++) {
            for (int j=0;j<triangle[i].length;j++) {
                dp[i+1][j+1] = Math.max(dp[i][j], dp[i][j+1]) + triangle[i][j];
            }
        }
        
        for (int i=1;i<=len;i++) {
            answer = Math.max(answer, dp[len][i]);
        }
        return answer;
    }
}