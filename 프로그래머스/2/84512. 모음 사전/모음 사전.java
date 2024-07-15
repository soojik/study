import java.util.*;

class Solution {
    char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    int answer = 0;
    int depth = -1;
    public int solution(String word) {
        find_str("", word);
        
        
        return answer;
    }
    
    public void find_str(String curr_word, String word) {
        ++depth;
        
        if (curr_word.equals(word)) {
            answer = depth;
            return;
        }
        if (curr_word.length() == 5) {
            return;
        }
        
        for (int i=0;i<5;i++) {
            find_str(curr_word + alpha[i], word);
        }
    }
}