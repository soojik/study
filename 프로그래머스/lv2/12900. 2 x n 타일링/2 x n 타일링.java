class Solution {
    public int solution(int n) {
        // i*2 에서의 경우의 수는 (i-1)*2, (i-2)*2 각 경우의 수의 합과 같다.
        int[] dp = new int[n + 1];
        
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3;i<=n;i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        
        return dp[n];
    }
}