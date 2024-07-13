import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer_list = new ArrayList();
        
        int day = 0;
        int len = speeds.length;
        Queue<int[]> q = new LinkedList();
        
        for (int i=0;i<len;i++) q.add(new int[]{progresses[i], speeds[i]});
        while (!q.isEmpty()) {
            ++day;
            
            int cnt = 0;
            
            // 개발 완료된 기능 다 빼기
            while (!q.isEmpty()) {
                int[] func = q.peek();
                if (100 <= func[0] + func[1] * day) {
                    ++cnt;
                    q.poll();
                    continue;
                }
                break;
            }
            
            if (0 < cnt) answer_list.add(cnt);
        }
        
        int[] answer = new int[answer_list.size()];
        
        int idx = 0;
        // List -> array
        for (int a : answer_list) answer[idx++] = a;
        
        return answer;
    }
}