import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0) return cities.length * 5;
        
        Queue<String> q = new LinkedList<>();
        for (int i=0;i<cities.length;i++) {
            String c = cities[i].toLowerCase();
            if (q.contains(c)) {
                q.remove(c);
                q.add(c);
                ++answer;
                continue;
            }
            if (cacheSize <= q.size()) {
                q.poll();
            }
            q.add(c);
            answer += 5;
        }
        
        return answer;
    }
}