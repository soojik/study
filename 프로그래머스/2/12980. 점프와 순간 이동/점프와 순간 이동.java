import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        // 순간 이동(*2): 0, 점프(+K): K
        while (1 <= n) {
            if (n % 2 == 1) {
                --n;
                ++ans;
                continue;
            }
            n /= 2;
        }

        return ans;
    }
}