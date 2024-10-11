import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int w : works) q.add(w);
        
        while (n-- > 0) {
            if (q.isEmpty()) return 0;
            if (q.peek() == 1) q.poll();
            else q.add(q.poll() - 1);
        }
        
        while (!q.isEmpty()) {
            answer += Math.pow(q.poll(), 2);
        }
        
        return answer;
    }
}