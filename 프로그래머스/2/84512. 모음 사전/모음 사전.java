class Solution {
    char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    int answer = 0;
    int depth = 0;
    public int solution(String word) {
        
        find("", word);
    
        return answer - 1;
    }
    
    void find(String curr, String word) {
        ++depth;
        
        if (curr.equals(word)) {
            answer = depth;
            return;
        }
        
        if (curr.length() == 5) return;
        
        for (int i=0;i<5;i++) {
            find(curr + alpha[i], word);
        }
    }
}