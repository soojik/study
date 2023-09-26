import java.util.List;
import java.util.ArrayList;

class Solution {
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        int ans_idx = 0;
        
        List<Integer> nums = new ArrayList();
        for (int i=1;i<=n;i++) nums.add(i);
        
        long[] fac = new long[n+1];
        
        fac[0] = 1;
        for (int i=1;i<=n;i++) fac[i] = fac[i-1] * i;
        
        int origin_n = n;
        
        while (ans_idx < origin_n) {
            long 몫 = k / fac[--n];
            long 나머지 = k % fac[n];
            
            if (나머지 == 0) {
                answer[ans_idx++] = nums.get((int) 몫 - 1);
                nums.remove((int) 몫 - 1);
                int size = nums.size();
                for (int i=0;i<size;i++) answer[ans_idx++] = nums.get(size - i - 1);
                
                return answer;
            }
            else if (나머지 == 1) {
                answer[ans_idx++] = nums.get((int) 몫);
                nums.remove((int) 몫);
                
                int size = nums.size();
                for (int i=0;i<size;i++) answer[ans_idx++] = nums.get(i);
                
                return answer;
            }
            else {
                answer[ans_idx++] = nums.get((int) 몫);
                nums.remove((int) 몫);
            }
            
            k = 나머지;
        }
        
        return answer;
    }
    
}