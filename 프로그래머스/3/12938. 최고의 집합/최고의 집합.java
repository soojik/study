import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {0, 0};
        
        if (n > s) return new int[]{-1};
        
        int[] nums = new int[n];
        Arrays.fill(nums, s/n);
        int idx = 0;
        for (int i=n-1;i>=n-s%n;i--) {
            ++nums[i];
        }
        
        return nums;
    }
}