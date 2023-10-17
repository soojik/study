class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        // 1/4 영역 중, x 또는 y 좌표가 0인 경우는 따로 r2, r1만 가지고 단순 계산할것이라 빼고 점 개수를 구한다.
        for (int i=1;i<r2;i++) {
            int r2dots = (int) Math.sqrt((long) Math.pow(r2, 2) - (long) Math.pow(i, 2));
            int r1dots = (int) Math.sqrt((long) Math.pow(r1, 2) - (long) Math.pow(i, 2));
            answer += (long) (r2dots - r1dots);
            
            // x 좌표 1 ~ r2 사이에 r1 원에 걸치는 점이 있다면 더해준다.
            if (i<r1
                && Math.sqrt((long) Math.pow(r1, 2) - (long) Math.pow(i, 2)) % 1 == 0) ++answer;
        }
        
        // 구한 점 개수에 4를 곱해주고, 두 원의 차이 + 1만큼의 점이 각 네 방향의 중심선 위에 올라가니까 더해준다.
        return (answer + (r2 - r1 + 1)) * 4;
    }
}