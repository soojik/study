import java.util.*;

class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        
        for (int i=0;i<n;i++) parent[i] = i;
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        int answer = 0;
        for (int[] c : costs) {
            if (find(c[0]) != find(c[1])) {
                union(c[0], c[1]);
                answer += c[2];
            }
        }
        
        return answer;
    }
    
    int find(int a) {
        if (parent[a] == a) return a;
        return find(parent[a]);
    }
    
    void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a == b) return;
        parent[b] = a;
    }
}