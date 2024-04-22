import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> leftTime = new LinkedList();
        
        for (int i=0;i<progresses.length;i++) {
            int leftPer = 100 - progresses[i];
            // 나눠서 소수점이 나온다면 하루 더 걸린다는 뜻
            leftTime.add(leftPer % speeds[i] == 0 ? leftPer / speeds[i] : leftPer / speeds[i] + 1);
        }
        
        List<Integer> ans = new ArrayList();
        
        while (!leftTime.isEmpty()) {
            int max_leftTime = leftTime.peek();
            int cnt = 0;
            while (!leftTime.isEmpty() && leftTime.peek() <= max_leftTime) {
                ++cnt;
                leftTime.poll();
            }
            
            ans.add(cnt);
        }
        
        int[] answer = new int[ans.size()];
        for (int i=0;i<ans.size();i++) answer[i] = ans.get(i);
        
        return answer;
    }
}
