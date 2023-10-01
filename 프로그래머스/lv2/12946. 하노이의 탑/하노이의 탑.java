class Solution {
    int[][] answer;
    int idx = 0;
    public int[][] solution(int n) {
        
        answer = new int[(int)Math.pow(2, n) - 1][2];
        
        moveRing(n, 1, 2, 3);
        
        return answer;
    }
    
    void moveRing(int n, int start, int waypoint, int dest) {
        // 옮길 링이 하나 남았다면
        if (n == 1) {
            // 출발지 - 도착지 answer 에 추가 후 종료
            answer[idx++] = new int[]{start, dest};
            return;
        }
        
        // 여러개 남았다면, 가장 큰 링을 제외한 위의 링들을 현재 빈 링에 옮긴다.
        moveRing(n-1, start, dest, waypoint);
        // 남은 링 하나는 answer 에 추가한다.
        answer[idx++] = new int[]{start, dest};
        // 옮겼던 링을 다시 남은(빈) 링에 옮긴다.
        moveRing(n-1, waypoint, start, dest);
    }
}