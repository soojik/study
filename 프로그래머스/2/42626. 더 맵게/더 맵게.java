import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for (int s : scoville) pq.add(s);
        
        while (2 <= pq.size() && pq.peek() < K) {
            pq.add(pq.poll() + pq.poll() * 2);
            ++answer;
        }
        
        return pq.peek() < K ? -1 : answer;
    }
}