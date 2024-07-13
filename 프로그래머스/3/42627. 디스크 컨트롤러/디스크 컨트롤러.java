import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (i1, i2) -> i1[0] - i2[0]);
        
        int len = jobs.length;
        
        // {시작점, 소요시간}
        Queue<int[]> q = new PriorityQueue<>((j1, j2) -> j1[1] - j2[1]);
        int idx = 0;
        int cnt = 0;
        int time = 0;
        while (cnt < len) {
            // time보다 작은 요청시간에 대한 작업 더하기
            while (idx < len && jobs[idx][0] <= time) {
                q.add(jobs[idx]);
                ++idx;
            }
            
            // 마칠 작업 있으면
            if (!q.isEmpty()) {
                int[] curr = q.poll();
                // 대기시간
                answer += curr[1] - curr[0] + time;
                // 현재 시간
                time += curr[1];
                ++cnt;
            }
            else {
                // 마칠 작업 없으면 다음 작업의 시작 시간으로 이동
                time = jobs[idx][0];
            }
        }
        
        return answer / len;
    }
}