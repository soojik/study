import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuffer answer = new StringBuffer();
        
        Stack<Integer> stack = new Stack();
        
        for (char c : number.toCharArray()) {
            int curr = c - '0';
            while (k > 0 && !stack.isEmpty() && stack.peek() < curr) {
                stack.pop();
                --k;
            }
            
            stack.push(curr);
        }
        
        while (k-- > 0) {
            stack.pop();
        }
        
        while (!stack.isEmpty()) answer.append(stack.pop());
        
        return answer.reverse().toString();
    }
}