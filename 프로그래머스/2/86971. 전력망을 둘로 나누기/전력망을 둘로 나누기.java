import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    boolean[][] con;
    public int solution(int n, int[][] wires) {
        
        con = new boolean[n + 1][n + 1];
        for (int[] w : wires) {
            con[w[0]][w[1]] = con[w[1]][w[0]] = true;
        }
        
        for (int[] w : wires) {
            int i1 = w[0];
            int i2 = w[1];
            
            con[i1][i2] = con[i2][i1] = false;
            int dist1 = bfs(i1, n);
            int dist2 = bfs(i2, n);
            answer = Math.min(answer, Math.abs(dist1 - dist2));
            con[i1][i2] = con[i2][i1] = true;
        }
        
        return answer;
    }
    
    int bfs(int start, int n) {
        Queue<Integer> q = new LinkedList();
        int cnt = 0;
        boolean[] visited = new boolean[n+1];
        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            ++cnt;
            
            for (int i=1;i<=n;i++) {
                if (visited[i] || !con[curr][i]) continue;
                visited[i] = true;
                q.add(i);
            }
        }
        
        return cnt;
    }
}