import java.util.*;

class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    int curr_max;
    int total_max = 0;
    boolean[][] visit;
    
    public int[] solution(int m, int n, int[][] picture) {
        
        int[] answer = new int[2];
        visit = new boolean[m][n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (visit[i][j] || picture[i][j] == 0) continue;
                curr_max = 1;
                visit[i][j] = true;
                dfs(i, j, 1, m, n, picture);
                total_max = Math.max(curr_max, total_max);
                ++answer[0];
            }
        }
        
        
        answer[1] = total_max;
        
        return answer;
        
    }
    
    void dfs(int r, int c, int depth, int m, int n, int[][] picture) {
        
        for (int i=0;i<4;i++) {

            int nr = r + dr[i];
            int nc = c + dc[i];
                
            if (0 <= nr && nr < m && 0 <= nc && nc < n) {
                if (!visit[nr][nc] && picture[nr][nc] == picture[r][c]) {
                    visit[nr][nc] = true;
                    ++curr_max;
                    dfs(nr, nc, depth+1, m, n, picture);
                }
            }
        }
    }
}