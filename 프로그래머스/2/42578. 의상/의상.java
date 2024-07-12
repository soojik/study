import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, HashSet<String>> map = new HashMap();
        for (String[] c : clothes) {
            HashSet<String> set = map.getOrDefault(c[1], new HashSet());
            set.add(c[0]);
            map.put(c[1], set);
        }
        
        for (String key : map.keySet()) {
            int size = map.get(key).size();
            answer *= (size+1);
        }
        
        return answer - 1;
    }
}