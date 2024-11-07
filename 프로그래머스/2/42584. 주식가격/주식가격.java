import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        
        Stack<int[]> stack = new Stack();
        for (int i=0;i<len;i++) {
            while (!stack.isEmpty() && prices[i] < stack.peek()[0]) {
                int[] p = stack.pop();
                answer[p[1]] = i - p[1];
            }
            stack.push(new int[]{prices[i], i});
        }
        
        while (!stack.isEmpty()) {
            int[] p = stack.pop();
            answer[p[1]] = len - p[1] - 1;
        }
        
        return answer;
    }
}