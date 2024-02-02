import java.util.*;

class Solution {
    Stack<Character>[] grid;
    boolean[][] visit;
    // 검사할 범위 설정(탐색 시작한 블럭에서 대각선 기준으로 네방향에 있는 블럭)
    int[][] move = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        // board를 Stack 배열로 변환해서 문제처럼 열을 기준으로 하나씩 Stack 에 넣어준다.
        grid = new Stack[n];
        // 방문 체크
        visit = new boolean[n][m];
        
        // board -> grid
        for (int i=0;i<n;i++) {
            grid[i] = new Stack();
            for (int j=m-1;j>=0;j--) {
                grid[i].push(board[j].charAt(i));
            }
        }
        
        // block은 터진 블록 개수
        int block = -1;
        // 터진 블록이 안나올 때까지
        while (block != 0) {
            // 방문 배열 초기화
            visit = new boolean[n][m];
            // 블록 개수 0으로 초기화
            block = 0;
            // 배열 돌며
            for (int i=0;i<n;i++) {
                for (int j=0;j<m;j++) {
                    // 만약 방문했거나 빈칸(@)이라면 탐색 하지 않음
                    if (visit[i][j] || grid[i].get(j) == '@') continue;
                    // 터진 블록에 visit 체크하는 메서드
                    getGoneBlock(i, j, m, n);
                }
            }
            
            // 터진 블록 개수
            block = blockDrop(m, n);
            answer += block;
        }
        
        return answer;
    }
    
    /**
    터진 블록은 삭제하고 삭제된 만큼 Stack에 빈칸값(@) 채워주기
    int m: 행
    int n: 열
    */
    int blockDrop(int m, int n) {
        int block = 0;
        for (int i=0;i<n;i++) {
            for (int j=m-1;j>=0;j--) {
                if (visit[i][j]) {
                    ++block;
                    grid[i].remove(j);
                    // 빈칸 채우기
                    grid[i].push('@');
                }
            }
        }
        
        // 터진 블록 개수 반환
        return block;
    }
    
    /**
    터진 블록 위치 visit에 체크
    */
    void getGoneBlock(int r, int c, int m, int n) {
        char block = grid[r].get(c);
        
        // 대각선 기준 네방향으로 움직이며
        for (int i=0;i<4;i++) {
            int nr = r + move[i][0];
            int nc = c + move[i][1];
            
            // 범위 안에 있고
            if (0 <= nr && nr < n && 0 <= nc && nc < m) {
                // 4블록이 같다면
                if (grid[nr].get(c) == block && grid[nr].get(nc) == block && grid[r].get(nc) == block) {
                    // 4블록 모두 방문체크
                    visit[r][c] = true;
                    visit[r][nc] = true;
                    visit[nr][c] = true;
                    visit[nr][nc] = true;
                }
            }
        }
    }
}