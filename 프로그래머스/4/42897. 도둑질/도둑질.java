import java.util.*;

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int len = money.length;
        int[] dp1 = new int[len];
        dp1[0] = money[0];
        dp1[1] = Math.max(money[1], money[0]);
        
        // 첫번째집 털고 마지막 안털기
        for (int i=2;i<len - 1;i++) {
           dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }
        
        // 첫번째집 안털고 마지막 털기
        int[] dp2 = new int[len];
        dp2[1] = money[1];
        for (int i=2;i<len;i++) {
           dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }
        
        return Math.max(dp1[len-2], dp2[len-1]);
    }
}