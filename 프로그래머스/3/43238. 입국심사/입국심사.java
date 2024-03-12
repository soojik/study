import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        // 예상 최소 소요 시간 중 최소 값과 최대 값
        long min = 1;
        long max = (long) times[0] * n;
        
        while (min < max) {
            // 예상 총 소요 시간
            long mid = (min + max) / 2;
            // mid가 총 소요시간일때 심사받을 수 있는 사람 수
            long 입국심사받는사람 = 0;
            
            // times 배열 돌면서 입국심사받는사람 계산
            for (int t : times) {
                입국심사받는사람 += mid / t;
            }
            
            // 만약 목표하는 수(n)보다 입국심사받는사람이 더 크거나 같다면 더 최소값 찾을 때까지
            if (n <= 입국심사받는사람) max = mid;
            // 아니면 시간을 늘려야하니까
            else min = mid + 1;
        }
        
        return min;
    }
}