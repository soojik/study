class Solution {
    int[] dr = {0, -1, 0, 1};
    int[] dc = {-1, 0, 1, 0};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int n = board.length;
        String origin_color = board[h][w];
    
        for (int i=0;i<4;i++) {
            int nr = h + dr[i];
            int nc = w + dc[i];
            if (0 <= nr && nr < n && 0 <= nc && nc < n) {
                if (origin_color.equals(board[nr][nc])) ++answer;
            }
        }
        
        return answer;
    }
}