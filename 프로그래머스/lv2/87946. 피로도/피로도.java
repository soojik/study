import java.util.*;

class Solution {
    int answer = 0;
    int len;
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        
        dfs(0, k, 0, new boolean[len], dungeons);
        
        return answer;
    }
    
    public void dfs(int count, int gague, int depth, boolean[] visit, int[][] dungeons) {
        for (int i=0;i<len;i++) {
            // 이미 거쳐왔거나 최소 필요 피로도가 현재 남은 피로도보다 크다면 탐색 넘기기
            if (visit[i] || (gague < dungeons[i][0])) continue;
            
            // 방문 체크 후
            visit[i] = true;
            // 다음 던전 탐색 진행
            dfs(count+1, gague-dungeons[i][1], depth+1, visit, dungeons);
            // 다른 던전 탐색 위해 방문 체크 해제
            visit[i] = false;
        }
        
        answer = Math.max(answer, count);
    }
}