import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] splited_arr = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String ss : splited_arr) {
            int result = Integer.parseInt(ss);
            min = Math.min(min, result);
            max = Math.max(max, result);
        }
        
        return min + " " + max;
    }
}