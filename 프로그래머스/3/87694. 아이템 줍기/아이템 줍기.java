import java.util.*;

class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    int[][] map = new int[102][102];
    int answer = 0;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            StringBuilder sb = new StringBuilder();
            for (int i=x1;i<=x2;i++) {
                for (int j=y1;j<=y2;j++) {
                    if (x1 < i && i < x2 && y1 < j && j < y2) {
                        map[i][j] = -1;
                    }
                    else if (map[i][j] == 0) map[i][j] = 1;
                }
            }
        }
        
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        return answer;
    }
    
    void bfs(int charX, int charY, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList();
        boolean[][] visited = new boolean[102][102];
        q.add(new int[]{charX, charY, 0});
        visited[charX][charY] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            if (curr[0] == itemX && curr[1] == itemY) {
                answer = curr[2] / 2;
                return;
            }
            
            int nr, nc;
            for (int i=0;i<4;i++) {
                nr = curr[0] + dr[i];
                nc = curr[1] + dc[i];
                
                if (0 <= nr && nr < 102 && 0 <= nc && nc < 102) {
                    if (visited[nr][nc] || map[nr][nc] != 1) continue;
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, curr[2] + 1});
                }
            }
        }
    }
}