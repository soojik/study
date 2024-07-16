import java.util.*;

class Solution {
    int n, m;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    int answer = Integer.MAX_VALUE;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        bfs(maps);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList();
        boolean[][] visited = new boolean[n][m];
        q.add(new int[]{0, 0, 1});
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            if (curr[0] == n-1 && curr[1] == m-1) {
                answer = Math.min(answer, curr[2]);
            }
            
            int nr, nc;
            for (int i=0;i<4;i++) {
                nr = curr[0] + dr[i];
                nc = curr[1] + dc[i];
                
                if (0 <= nr && nr < n && 0 <= nc && nc < m) {
                    if (visited[nr][nc] || maps[nr][nc] == 0) continue;
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, curr[2] + 1});
                }
            }
        }
    }
}