import java.util.*;

class Solution {
    StringBuilder answer = new StringBuilder();
    HashMap<Character, Integer> point = new HashMap();
    public String solution(String[] survey, int[] choices) {
        
        int len = survey.length;
        
        // 모든 유형 점수 초기화
        point.put('R', 0);
        point.put('T', 0);
        point.put('C', 0);
        point.put('F', 0);
        point.put('J', 0);
        point.put('M', 0);
        point.put('A', 0);
        point.put('N', 0);
        
        for (int i=0;i<len;i++) {
            // 고르지 않았다면 넘어가기
            if (choices[i] == 4) continue;
            
            char c1 = survey[i].charAt(0);
            char c2 = survey[i].charAt(1);
            
            // 해당하는 유형에 점수 더해주기
            if (choices[i] > 4) {
                point.put(c2, point.get(c2) + choices[i] - 4);
            }
            else {
                point.put(c1, point.get(c1) + 4 - choices[i]);
            }
        }
        
        // 각 유형 비교해 answer에 더해주기
        answer.append(getHigherChar("RT"));
        answer.append(getHigherChar("CF"));
        answer.append(getHigherChar("JM"));
        answer.append(getHigherChar("AN"));
        
        return answer.toString();
    }
    
    public char getHigherChar(String str) {
        char c1 = str.charAt(0);
        char c2 = str.charAt(1);
        
        // 두 유형의 점수가 같다면 사전순 앞에 오는 문자를 반환
        if (point.get(c1) == point.get(c2)) return (char) Math.min((int) c1, (int) c2);
 
        // 그 외의 경우는 점수가 큰 유형을 반환
        if (point.get(c1) > point.get(c2)) return c1;
        
        return c2;
    }
}