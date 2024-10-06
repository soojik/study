class Solution {
    int len;
    boolean[] visited;
    int answer = -1;
    public int solution(int k, int[][] dungeons) {
        
        len = dungeons.length;
        visited = new boolean[len];
        
        dfs(k, dungeons, 0);
        
        return answer;
    }
    
    void dfs(int k, int[][] dungeons, int depth) {
        
        answer = Math.max(answer, depth);
        
        for (int i=0;i<len;i++) {
            if (visited[i] || k < dungeons[i][0]) continue;
            visited[i] = true;
            dfs(k - dungeons[i][1], dungeons, depth + 1);
            visited[i] = false;
        }
    }
}