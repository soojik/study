class Solution {
    int answer = 0;
    int len;
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        
        탐험(0, k, dungeons, new boolean[len]);
        
        return answer;
    }
    
    public void 탐험(int depth, int 피로도, int[][] d, boolean[] visited) {
        answer = Math.max(answer, depth);
        
        for (int i=0;i<len;i++) {
            if (visited[i] || 피로도 < d[i][0]) continue;
            visited[i] = true;
            탐험(depth + 1, 피로도 - d[i][1], d, visited);
            visited[i] = false;
        }
    }
}