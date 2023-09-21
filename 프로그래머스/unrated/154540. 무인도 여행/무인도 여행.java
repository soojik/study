import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    int sum;
    int r_len, c_len;
    boolean[][] visit;
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList();;
        
        r_len = maps.length;
        c_len = maps[0].length();
        visit = new boolean[r_len][c_len];
        
        for (int i=0;i<r_len;i++) {
            for (int j=0;j<c_len;j++) {
                if (maps[i].charAt(j) != 'X' && !visit[i][j]) {
                    sum = maps[i].charAt(j) - '0';
                    visit[i][j] = true;
                    dfs(maps, i, j);
                    list.add(sum);
                }
            }
        }
        
        int size = list.size();
        if (size == 0) return new int[]{-1};
        
        Collections.sort(list);
        
        int[] answer = new int[size];
        for (int i=0;i<size;i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    void dfs(String[] maps, int r, int c) {
        
        int nr, nc;
        for (int i=0;i<4;i++) {
            nr = r + dr[i];
            nc = c + dc[i];
            if (!(0 <= nr && nr < r_len && 0 <= nc && nc < c_len)) continue;
            if (maps[nr].charAt(nc) != 'X' && !visit[nr][nc]) {
                visit[nr][nc] = true;
                sum += maps[nr].charAt(nc) - '0';
                dfs(maps, nr, nc);
            }
        }
    }
}