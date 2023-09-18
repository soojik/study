import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        int len = number.length();
        StringBuilder answer = new StringBuilder();
        
        // number 에서 수를 차례로 꺼내 stack 에 넣으며 최대한 최댓값이 앞으로 오도록 한다.
        Stack<Integer> stack = new Stack();
        
        // number 에 숫자를 순회 
        for (char c : number.toCharArray()) {
            // stack 에 값이 있으면서, 맨 윗 값이 현재 비교할 number 의 수보다 작으면서 숫자를 제거할 기회가 있다면
            while (!stack.isEmpty() && stack.peek() < c - '0' && k > 0) {
                // stack 에서 모두 뽑아내고
                stack.pop();
                // 제거권 감소
                --k;
            }
            
            // 비교한 숫자는 stack 에 넣어준다.
            stack.push(c - '0');
        }
        
        // stack 에서 제거권 남은만큼 꺼내주고
        for (int i=0;i<k;i++) stack.pop();
        
        // 남은 수는 모두 answer 에 넣어준다.
        while (!stack.isEmpty()) answer.append(stack.pop());
        
        // 후입선출 구조이므로 reverse 후에 문자열로 변환
        return answer.reverse().toString();
    }
}