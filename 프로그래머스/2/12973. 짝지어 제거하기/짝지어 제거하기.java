import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        Stack<Character> stack = new Stack();
        
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            
            if (stack.peek() == c) {
                stack.pop();
                continue;
            }
            
            stack.push(c);
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}