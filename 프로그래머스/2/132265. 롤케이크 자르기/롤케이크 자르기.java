import java.util.*;

class Solution {
    // 동생 - {토핑, 수}
    Map<Integer, Integer> map = new HashMap();
    // 철쑤 - {토핑}
    Set<Integer> set = new HashSet();
    int len;
    public int solution(int[] topping) {
        int answer = 0;
        
        len = topping.length;
        
        for (int i=0;i<len;i++) {
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        }
        
        for (int i=0;i<len;i++) {
            set.add(topping[i]);
            int cnt = map.get(topping[i]) - 1;
            if (cnt == 0) map.remove(topping[i]);
            else map.put(topping[i], cnt);
            if (map.size() == set.size()) ++ answer;
        }
        
        return answer;
    }
}