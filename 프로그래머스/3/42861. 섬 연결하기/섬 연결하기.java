import java.util.*;

class Solution {
    PriorityQueue<int[]> pq;
    int[] parents;
    public int solution(int n, int[][] costs) {
        // {섬1, 섬2, 비용}
        int answer = 0;
        Arrays.sort(costs, (i1, i2) -> i1[2] - i2[2]);
        
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        pq = new PriorityQueue<>((i1, i2) -> i1[2] - i2[2]);
        
        for (int[] c : costs) {
            pq.add(c);
        }
        
        while(!pq.isEmpty()) {
            
            int[] curr = pq.poll();
            
            if (!isConnected(curr[0], curr[1])) {
                answer += curr[2];
                unionParent(curr[0], curr[1]);
            }
        }
        
        return answer;
    }
    
    int getParent(int n) {
        if (parents[n] == n) return n;
        return parents[n] = getParent(parents[n]);
    }
    
    boolean isConnected(int n1, int n2) {
        return getParent(n1) == getParent(n2);
    }
    
    void unionParent(int n1, int n2) {
        n1 = getParent(n1);
        n2 = getParent(n2);
        
        if (n1 < n2) parents[n2] = n1;
        else parents[n1] = n2;
    }
}