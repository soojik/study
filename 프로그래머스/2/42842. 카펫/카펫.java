class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int h = 1;
        int w;
        int whole = brown + yellow;
        while (h <= brown) {
            if (whole % h != 0) {
                ++h;
                continue;
            }
            w = whole / h;
            if ((h - 2) * (w - 2) == yellow && w * h == whole) return new int[]{w, h};
            ++h;
        }
        
        return answer;
    }
}