import java.util.*;

class Solution {
    int[] dist;
    boolean[][] con;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        dist = new int[n + 1];
        con = new boolean[n+1][n+1];
        for (int[] e : edge) {
            con[e[0]][e[1]] = con[e[1]][e[0]] = true;
        }
        
        bfs(n);
        
        int max = 0;
        for (int d : dist) max = Math.max(d, max);
        for (int d : dist) if (max == d) ++answer;
        
        return answer;
    }
    
    void bfs(int n) {
        Queue<int[]> q = new LinkedList();
        boolean[] visited = new boolean[n+1];
        q.add(new int[]{1, 0});
        visited[1] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            dist[curr[0]] = Math.max(dist[curr[0]], curr[1]);
            
            for (int i=2;i<=n;i++) {
                if (visited[i] || !con[curr[0]][i]) continue;
                visited[i] = true;
                q.add(new int[]{i, curr[1] + 1});
            }
        }
    }
}