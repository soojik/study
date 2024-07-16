import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        
        visited = new boolean[n];
        for (int i=0;i<n;i++) {
            if (visited[i]) continue;
            bfs(i, n, computers);
            ++answer;
        }
        
        return answer;
    }
    
    void bfs(int start, int n, int[][] computers) {
        Queue<Integer> q = new LinkedList();
        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int i=0;i<n;i++) {
                if (visited[i] || computers[curr][i] == 0) continue;
                visited[i] = true;
                q.add(i);
            }
        }
    }
}