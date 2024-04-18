import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> par = new HashMap();
        for (String p : completion) par.put(p, par.getOrDefault(p, 0) + 1);
        
        for (String c : participant) {
            if (!par.containsKey(c) || par.get(c) == 0) return c;
            par.put(c, par.get(c) - 1);
        }
        
        return answer;
    }
}