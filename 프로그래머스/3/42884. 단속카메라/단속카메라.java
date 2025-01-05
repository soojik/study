import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int lastCam = routes[0][1];
        
        for (int[] r : routes) {
            if (r[0] <= lastCam) {
                continue;
            }
            
            lastCam = r[1];
            ++answer;
        }
        
        return answer;
    }
}