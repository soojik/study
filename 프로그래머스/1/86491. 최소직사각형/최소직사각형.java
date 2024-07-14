class Solution {
    public int solution(int[][] sizes) {
        
        int i = 0;
        int max_w = 0, max_h = 0;
        for (int[] s : sizes) {
            max_w = Math.max(max_w, Math.max(s[0], s[1]));
            max_h = Math.max(max_h, Math.min(s[0], s[1]));
        }
        
        return max_w * max_h;
    }
}