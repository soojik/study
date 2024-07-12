import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book, (p1, p2) -> p1.length() - p2.length());
        
        HashSet<String> prev_num = new HashSet();

        StringBuffer sb;
        for (String p : phone_book) {
            sb = new StringBuffer();
            for (char c : p.toCharArray()) {
                if (prev_num.contains(sb.append(c).toString())) return false;
            }
            prev_num.add(p);
        }
        
        return answer;
    }
}