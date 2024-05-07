import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int s : scoville) pq.add(s);
        
        while (2 <= pq.size()) {
            if (K <= pq.peek()) return answer;
            
            int food1 = pq.poll();
            int food2 = pq.poll();
            
            pq.add(food1 + food2 * 2);
            ++answer;
        }
        
        
        return (K <= pq.peek() ? answer : -1);
    }
}