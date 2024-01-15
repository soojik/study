import java.util.*;

class Solution {
    int len_r, len_c;
    // 시작점, 끝점, 넓이
    Set<int[]> info = new HashSet();
    int[] dr = {0, -1, 0, 1};
    int[] dc = {-1, 0, 1, 0};
    int[][] new_land;
    int 시작열, 끝열, 넓이;
    public int solution(int[][] land) {
        
        len_r = land.length;
        len_c = land[0].length;
        new_land = land;
        for (int i=0;i<len_r;i++) {
            for (int j=0;j<len_c;j++) {
                if (land[i][j] == 0) continue;
                land[i][j] = 0;
                시작열 = 끝열 = j;
                넓이 = 0;
                dfs(i, j);
                // 만약 dfs 후 넓이 값이 1이라면 이동할 칸이 없단 뜻이니까 현재 위치에 넓이값은 1로 넣어주기
                if (넓이 == 1) info.add(new int[]{j, j, 1});
                else info.add(new int[]{시작열, 끝열, 넓이});
            }
        }
        
        // 구한 영역 정보 순회하며 가로길이(m == len_c) 만큼의 배열 만들어준 다음, index열에 최대 얼만큼 석유를 팔 수 있는지 저장
        int[] answer = new int[len_c];
        for (int[] area : info) {
            for (int i=area[0];i<=area[1];i++) answer[i] += area[2];
        }
        
        int max = 0;
        for (int a : answer) max = Math.max(a, max);
        
        return max;
    }
    
    /* 각 영역의 넓이 및 시작, 끝열 찾기 */
    void dfs (int r, int c) {
        시작열 = Math.min(시작열, c);
        끝열 = Math.max(끝열, c);
        ++넓이;
        for (int i=0;i<4;i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (0 <= nr && nr < len_r && 0 <= nc && nc < len_c) {
                if (new_land[nr][nc] == 1) {
                    new_land[nr][nc] = 0;
                    dfs(nr, nc);
                }
            }
        }
    }
}