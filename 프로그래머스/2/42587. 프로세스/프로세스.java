import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 인덱스, 우선순위
        Queue<int[]> q = new LinkedList();
        PriorityQueue<Integer> priors = new PriorityQueue<>((i1, i2) -> i2 - i1);
        
        int len = priorities.length;
        for (int i=0;i<len;i++) {
            q.add(new int[]{i, priorities[i]});
            priors.add(priorities[i]);
        }
        
        while (!q.isEmpty()) {
            ++answer;
            while (q.peek()[1] != priors.peek()) {
                q.add(q.poll());
            }
            priors.poll();
            int[] curr = q.poll();
            if (curr[0] == location) return answer;
        }
        
        return answer;
    }
}