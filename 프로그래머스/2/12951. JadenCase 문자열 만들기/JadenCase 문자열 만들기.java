import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (i == 0 || s.charAt(i-1) == ' ') {
                if (Character.isAlphabetic(c)) {
                    answer.append(Character.toUpperCase(c));
                }
                else {answer.append(c);}
                continue;
            }
            else {
                if (Character.isAlphabetic(c)) {
                    answer.append(Character.toLowerCase(c));
                }
                else {answer.append(c);}
            }
            
        }
        
        return answer.toString();
    }
}