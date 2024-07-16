import java.util.*;

class Solution {
    int len;
    int word_len;
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        len = words.length;
        word_len = words[0].length();
        
        int idx = 0;
        for (String w : words) {
            if (valid(w, begin)) {
                bfs(idx, target, words);
            }
            ++idx;
        }
        if (answer == Integer.MAX_VALUE) return 0;
        return answer + 1;
    }
    
    void bfs(int start_idx, String target, String[] words) {
        Queue<int[]> q = new LinkedList();
        boolean[] visited = new boolean[len];
        
        q.add(new int[]{start_idx, 0});
        visited[start_idx] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            if (words[curr[0]].equals(target)) {
                answer = Math.min(answer, curr[1]);
            }
            
            for (int i=0;i<len;i++) {
                if (visited[i] || !valid(words[curr[0]], words[i])) continue;
                visited[i] = true;
                q.add(new int[]{i, curr[1] + 1});
            }
        }
    }
    
    boolean valid(String word1, String word2) {
        int cnt = 0;
        for (int i=0; i<word_len; i++) {
            if (word1.charAt(i) != word2.charAt(i)) ++cnt;
        }
        
        return cnt == 1;
    }
}