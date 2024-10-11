class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        boolean[][] isPuddle = new boolean[n+1][m+1];
        for (int[] p : puddles) {
            isPuddle[p[1]][p[0]] = true;
        }
        
        int[][] dp = new int[n+1][m+1];
        
        for (int i=1;i<=m;i++) {
            if (isPuddle[1][i]) break;
            dp[1][i] = 1;
        }
        for (int i=1;i<=n;i++){
            if (isPuddle[i][1]) break;
            dp[i][1] = 1;
        } 
        
        for (int i=2;i<=n;i++) {
            for (int j=2;j<=m;j++) {
                if (isPuddle[i][j]) continue;
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
            }
        }
        
        return dp[n][m];
    }
}