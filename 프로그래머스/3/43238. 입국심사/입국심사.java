class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        int max = 0;
        for (int t : times) max = Math.max(max, t);
        
        long start = 1;
        long end = max * (long)n;
        
        while (start <= end) {
            long mid = (start + end) / 2;
            long people = 0;
            
            for (long t : times) {
                people += mid / t;
            }
            
            if (n <= people) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        
        return start;
    }
}