class Solution
{
    int r_len, c_len;
    public int solution(int [][]board)
    {
        
        r_len = board.length;
        c_len = board[0].length;
        
        // dp{i, j}에는 board{i-1, j-1}를 우하단 지점을 기준으로 가장 긴 길이의 한 변의 길이
        int[][] dp = new int[r_len+1][c_len+1];
        
        int max_size = 0;
        for (int i=1;i<=r_len;i++) {
            for (int j=1;j<=c_len;j++) {
                if (board[i-1][j-1] == 0) continue;
                // 직전 세방향에서 0이 하나라도 있으면 정사각형이 이루어지지 않는다.
                dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + board[i-1][j-1];
                
                // 최댓값 업데이트
                max_size = Math.max(max_size, dp[i][j]);
            }
        }
        
        return max_size * max_size;
    }
}