import java.util.*;

class Solution {
    public String solution(String p) {
        return recursive(p);
    }
    
    public String recursive(String p) {
        // 만약 p가 빈 문자열이면 그대로 반환
        if (p.equals("")) return "";
        
        // step 2
        String[] u_v = getu_v(p);
        
        String str = recursive(u_v[1]);
        
        // step 3
        if (isValid(u_v[0])) {
            // step 3-1
            return u_v[0] + str;
        }
        // step 4
        else {
            StringBuilder u = new StringBuilder(u_v[0]);
            u.deleteCharAt(u.length()-1);
            if (u.length() > 0) u.deleteCharAt(0);
            u = reverseChar(u);
            StringBuilder result = new StringBuilder();
            return result.append('(').append(str).append(')').append(u).toString();
        }
    }
    
    public StringBuilder reverseChar(StringBuilder sb) {
        StringBuilder result = new StringBuilder();
        for (int i=0;i<sb.length();i++) {
            result.append(sb.charAt(i) == '(' ? ')' : '(');
        }
        
        return result;
    }
    
    // 올바른 괄호 문자열인지 확인하는 메서드
    public boolean isValid(String u) {
        Stack<Character> stack = new Stack();
        for (char c : u.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                continue;
            }
            
            // c == ')'
            if (stack.isEmpty()) return false;
            
            if (stack.peek() == '(') stack.pop();
        }
        
        return stack.isEmpty();
    }
    
    // u와 v를 균형잡힌 괄호 문자열로 나누는 메서드 
    public String[] getu_v(String p) {
        Stack<Character> stack = new Stack();
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        int i;
        for (i=0;i<p.length();i++) {
            char c = p.charAt(i);
            u.append(c);
            if (stack.isEmpty()) stack.push(c);
            else {
                if (stack.peek() == c) stack.push(c);
                else {
                    stack.pop();
                    if (stack.isEmpty()) break;
                }
            }
        }
        for (int j=i+1;j<p.length();j++) v.append(p.charAt(j));
        
        return new String[]{u.toString(), v.toString()};
    }
}