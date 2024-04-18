import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, HashSet<String>> type_name = new HashMap();
        
        for (String[] c : clothes) {
            String type = c[1];
            String name = c[0];
            
            if (!type_name.containsKey(type)) type_name.put(type, new HashSet());
            
            type_name.get(type).add(name);
        }
        
        for (String key : type_name.keySet()) {
            answer *= (type_name.get(key).size() + 1);
        }
        
        return answer - 1;
    }
}