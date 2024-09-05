import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int p1 = 0, p2 = 1;
        int sum = 1;
        
        while (p1 <= p2 && p2 <= n) {
            if (sum == n) {
                ++answer;
                sum += ++p2;
                continue;
            }
            
            if (sum < n) {
                sum += ++p2;
                continue;
            }
            
            if (n < sum) {
                sum -= p1++;
            }
        }
        
        return answer;
    }
}