class Solution {
    int[] answer = {0, 0};
    public int[] solution(int[][] arr) {
        
        // 주어진 배열 arr의 한 변의 길이
        int len = arr.length;
        // {0, 0} 부터 한 영역 안에 있는 수가 같아질 때까지 반복하며 최종적으로 해당 영역에 통일된 값에 따라 answer에 더해준다.
        dfs(0, 0, len, arr);
        
        return answer;
    }
    
    /*
    r, c: 탐색 영역의 좌상단 좌표
    size: 탐색 영역의 한 변의 길이
    arr: 주어진 배열
    */
    void dfs(int r, int c, int size, int[][] arr) {
        // 현재 영역 ({r, c} 부터 size 만큼의 정사각형) 안에 있는 수가 모두 같으면 answer[통일된 수] 값을 1 증가시키고 재귀 호출을 종료한다.
        if (isValid(r, c, size, arr)) {
            ++answer[arr[r][c]];
            return;
        }
        
        // 그 이외는 다시 네구역으로 나누어 탐색 진행한다.
        dfs(r, c, size/2, arr);
        dfs(r+size/2, c, size/2, arr);
        dfs(r, c+size/2, size/2, arr);
        dfs(r+size/2, c+size/2, size/2, arr);
    }
    
    // {r, c} 부터 한 변의 길이가 size 인 정사각형 영역 안에 있는 수가 같은지를 판별하는 메서드
    boolean isValid(int r, int c, int size, int[][] arr) {
        int value = arr[r][c];
        for (int i=r;i<r+size;i++) {
            for (int j=c;j<c+size;j++) {
                if (value != arr[i][j]) return false;
            }
        }
        
        return true;
    }
}