import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        while (!s.equals("1")) {
            ++answer[0];
            
            int len = s.replaceAll("0", "").length();

            answer[1] += s.length() - len;
        
            s = changeToBinary(len);
        }
        
        // [변환 횟수, 제거된 0 갯수]
        return answer;
    }
    
    public String changeToBinary(int len) {
        StringBuilder sb = new StringBuilder();
        while (1 <= len) {
            sb.append(len % 2);
            len /= 2;
        }
        
        return sb.reverse().toString();
    }
}