import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack();
        
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                if (c == ')') return false;
                stack.push(c);
                continue;
            }
            
            if (c == '(') stack.push(c);
            else {
                if (stack.peek() == '(') stack.pop();
                else return false;
            }
        }

        return stack.isEmpty();
    }
}