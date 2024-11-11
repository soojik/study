class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        
        int len_r = board.length;
        int len_c = board[0].length;
        int[][] dp = new int[len_r][len_c];
        
        for (int i=0;i<len_r;i++) {
            for (int j=0;j<len_c;j++) {
                if (board[i][j] == 0) continue;
                if (i == 0 || j == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }
            }
        }
        
        for (int i=0;i<len_r;i++) {
            for (int j=0;j<len_c;j++) answer = Math.max(answer, dp[i][j]);
        }

        return (int) Math.pow(answer, 2);
    }
}