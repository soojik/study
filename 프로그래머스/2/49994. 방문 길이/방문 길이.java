import java.util.*;

class Solution {
    // 행, 열, 방향 (상, 좌, 하, 우)
    boolean[][][] visited = new boolean[11][11][4];
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    public int solution(String dirs) {
        int answer = 0;
        
        Map<Character, Integer> dir = new HashMap();
        dir.put('U', 0);
        dir.put('L', 1);
        dir.put('D', 2);
        dir.put('R', 3);
        
        int curr_r = 5;
        int curr_c = 5;
        for (char d : dirs.toCharArray()) {
            int next_r = curr_r + dr[dir.get(d)];
            int next_c = curr_c + dc[dir.get(d)];
            if (0 <= next_r && next_r <= 10 && 0 <= next_c && next_c <= 10) {
                if (!visited[curr_r][curr_c][dir.get(d)]) {
                    ++answer;
                    visited[curr_r][curr_c][dir.get(d)] = true;
                    visited[next_r][next_c][(dir.get(d) + 2) % 4] = true;
                }
                curr_r = next_r;
                curr_c = next_c;
            }
        }
        
        return answer;
    }
}