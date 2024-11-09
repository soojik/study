import java.util.*;

class Solution {
    // 10일 연속
    Map<String, Integer> wants = new HashMap();
    Map<String, Integer> 바구니 = new HashMap();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for (int i=0;i<want.length;i++) {
            wants.put(want[i], number[i]);
        }
        
        for (int i=0;i<10;i++) {
            바구니.put(discount[i], 바구니.getOrDefault(discount[i], 0) + 1);
        }
        
        if (valid()) ++answer;
        
        for (int i=10;i<discount.length;i++) {
            바구니.put(discount[i], 바구니.getOrDefault(discount[i], 0) + 1);
            
            int num = 바구니.get(discount[i - 10]);
            if (num == 1) 바구니.remove(discount[i - 10]);
            else 바구니.put(discount[i - 10], num - 1);
            
            if (valid()) ++answer;
        }
        
        return answer;
    }
    
    boolean valid() {
        for (String key : wants.keySet()) {
            if (바구니.getOrDefault(key, 0) != wants.get(key)) return false;
        }
        
        return true;
    }
}