class Solution {
    public int solution(String name) {
        int answer = 0; 
        int len = name.length();
        int move = len - 1;
        
        
        for (int i = 0; i < len; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            int nextIdx = i + 1;
            while (nextIdx < len && name.charAt(nextIdx) == 'A') {
                nextIdx++;
            }

            move = Math.min(move, i + len - nextIdx + Math.min(i, len - nextIdx));
        }
        
        answer += move;
        return answer;
    }
}