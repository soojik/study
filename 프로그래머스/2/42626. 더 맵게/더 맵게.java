import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        PriorityQueue<Integer> q = new PriorityQueue<>((i1, i2) -> i1 - i2);
        for (int s : scoville) q.add(s);
        
        while (!q.isEmpty()) {
            if (q.size() == 1) {
                return q.poll() >= K ? answer : -1;
            }
            
            if (q.peek() >= K) return answer;
            
            int new_score = q.poll() + q.poll() * 2;
            q.add(new_score);
            ++answer;
        }
        
        return answer;
    }
}