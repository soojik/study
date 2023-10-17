class Solution {
    int answer = 0;
    // 퀸의 위치를 나타낼 배열
    int[] occupied;
    public int solution(int n) {
        
        occupied = new int[n];
        
        backtracking(n, 0);
        
        return answer;
    }
    
    // 퀸을 놓을 수 있는 방법을 모두 탐색한다.
    public void backtracking (int n, int depth) {
        // 퀸 위치를 다 잡았다면 answer 1 증가
        if (depth == n) {
            ++answer;
            return;
        }
        
        // 탐색 중
        for (int i=0;i<n;i++) {
            // 퀸 자리를 하나 놓고
            occupied[depth] = i;
            
            // 만약 퀸을 놓을 수 있다면
            if (isValid(depth)) {
                // 다음 자리 탐색
                backtracking(n, depth+1);
            }
        }
    }
    
    // 다른 퀸이 같은 선상에 있지 않고, 대각선에 있지 않은지 확인한다.
    public boolean isValid (int curr) {
        for (int i=0;i<curr;i++) {
            if (occupied[i] == occupied[curr]
                || Math.abs(i - curr) == Math.abs(occupied[i] - occupied[curr])) return false;
        }
        
        return true;
    }
}