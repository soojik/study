import java.util.*;

class Solution {
    int len;
    public int solution(String s) {
        int answer = 0;
        
        len = s.length();
        
        for (int i=0;i<len;i++) {
            if (check(s, i)) {
                ++answer;
            }
        }
        
        return answer;
    }
    
    boolean check(String s, int start_idx) {
        Deque<Character> stack = new LinkedList();
        
        int idx = start_idx;
        for (int i=0;i<len;i++) {
            char c = s.charAt((idx+i)%len);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            
            if (c == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
                else return false;
            }
            
            if (c == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                    continue;
                }
                else return false;
            }
            
            if (c == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
                else return false;
            }
        }
        
        return stack.isEmpty();
    }
}