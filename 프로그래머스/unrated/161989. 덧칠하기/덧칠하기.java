class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        
        int len = section.length;
        // section의 순회를 위한 인덱스
        int idx = 1;
        // 페인트질 시작점
        int start = section[0];
        
        while (idx < len) {
            // 만약 현재 페인트칠의 범위 안에 있다면
            if (section[idx] < start + m) {
                // 다음 탐색
                ++idx;
                continue;
            }
            
            // 아니라면 다음 칠할 곳을 페인트칠 시작점으로 지정 후 answer 1 증가
            start = section[idx++];
            ++answer;
        }
        
        return answer;
    }
}