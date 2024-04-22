import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack();
        
        for (int num : arr) {
            if (!stack.isEmpty() && stack.peek() == num) continue;
            stack.push(num);
        }
        
        int[] answer = new int[stack.size()];
        int idx = 0;
        for (int num : stack) answer[idx++] = num;

        return answer;
    }
}