import java.util.Queue;
import java.util.LinkedList;

class Solution {
    int[] dr = {0, -1, 0, 1};
    int[] dc = {-1, 0, 1, 0};
    public int solution(int[][] maps) {
        int len_r = maps.length;
        int len_c = maps[0].length;
        
        // 방문체크 배열
        boolean[][] visit = new boolean[len_r][len_c];
        // 초기 위치 {0, 0}부터 {i, j}까지 몇칸이 걸리는지
        int[][] cnt = new int[len_r][len_c];
        
        // 다음에 탐색할 칸 위치정보 담을 Queue
        Queue<int[]> q = new LinkedList();
        // 초기 위치 정보 담아주기
        q.add(new int[]{0, 0});
        
        // BFS(넓이 우선 탐색)을 이용해 초기 위치부터 동서남북, 갈 수 있는 곳(&&방문하지 않은 곳)을 Queue에 넣어주며 더 이상 탐색할 곳이 없을 때까지 반복문을 수행
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            // 도착했다면 가장 빠른 거리이므로 {0, 0}부터 현재 위치{len_r - 1, len_c - 1}까지 걸린 칸 수에 초기에 안 세었던 칸을 위해 1을 더해준다.
            if (curr[0] == len_r - 1 && curr[1] == len_c - 1) {
                return cnt[len_r - 1][len_c - 1] + 1;
            }
            
            // 동서남북 탐색
            for (int i=0;i<4;i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];
                
                if (0 <= nr && nr < len_r && 0 <= nc && nc < len_c) {
                    if (!visit[nr][nc] && maps[nr][nc] == 1) {
                        // 미리 방문 체크함으로써 중복으로 Queue에 대기되는 것을 방지한다.
                        visit[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                        if (cnt[nr][nc] == 0) cnt[nr][nc] = cnt[curr[0]][curr[1]] + 1;
                        else cnt[nr][nc] = Math.min(cnt[curr[0]][curr[1]] + 1, cnt[nr][nc]);
                    }
                }
            }
        }
        
        // 앞선 탐색에서 도착하지 못했다면 -1 반환
        return -1;
    }
}