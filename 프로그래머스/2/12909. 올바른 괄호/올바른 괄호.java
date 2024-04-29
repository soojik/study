import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack();
        
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || c == '(') {
                stack.push(c);
                continue;
            }
            
            if (stack.peek() == '(') {
                if (c == ')') {
                    stack.pop();
                    continue;
                }
                return false;
            }
        }
        

        return stack.isEmpty() ? true : false;
    }
}