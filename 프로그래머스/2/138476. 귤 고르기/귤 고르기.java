import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int key : map.keySet()) {
            q.add(map.get(key));
        }
        
        int sum = 0;
        while (!q.isEmpty()) {
            ++answer;
            sum += q.poll();
            
            if (k <= sum) {
                return answer;
            }
        }
        
        return answer;
    }
}