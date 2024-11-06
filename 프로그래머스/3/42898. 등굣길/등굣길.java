class Solution {
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] puddle = new boolean[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        
        for (int[] p : puddles) {
            puddle[p[1]][p[0]] = true;
        }
        
        for (int i=1;i<=n;i++) {
            if (puddle[i][1]) break;
            dp[i][1] = 1;
        }
        
        for (int i=1;i<=m;i++) {
            if (puddle[1][i]) break;
            dp[1][i] = 1;
        }
        
        for (int i=2;i<=n;i++) {
            for (int j=2;j<=m;j++) {
                if (puddle[i][j]) continue;
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
            }
        }
        
        return dp[n][m];
    }
}