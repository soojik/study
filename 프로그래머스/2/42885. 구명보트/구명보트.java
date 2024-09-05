import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Deque<Integer> dq = new ArrayDeque();
        Arrays.sort(people);
        
        for (int p : people) {
            dq.offerFirst(p);
        }
        
        int boat;
        int cnt;
        while (!dq.isEmpty()) {
            boat = 0;
            cnt = 0;
            
            while (!dq.isEmpty() && dq.peekFirst() + boat <= limit && cnt < 2) {
                boat += dq.pollFirst();
                ++cnt;
            }
            
            while (!dq.isEmpty() && dq.peekLast() + boat <= limit && cnt < 2) {
                boat += dq.pollLast();
                ++cnt;
            }
            
            ++answer;
        }
        
        return answer;
    }
}