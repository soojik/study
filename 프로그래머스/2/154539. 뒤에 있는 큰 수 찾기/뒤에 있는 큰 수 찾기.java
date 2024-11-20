import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        
        int[] answer = new int[N];
        
        Stack<Integer> stack = new Stack();
        for (int i=N-1;i>=0;i--) {
            if (stack.isEmpty()) {
                answer[i] = -1;
                stack.push(numbers[i]);
                continue;
            }
            
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(numbers[i]);
        }
        
        return answer;
    }
}
