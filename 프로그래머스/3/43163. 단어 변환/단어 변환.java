import java.util.*;

class Solution {
    int answer = 0;
    public int solution(String begin, String target, String[] words) {
        
        bfs(begin, target, words);
        
        return answer;
    }
    
    void bfs(String begin, String target, String[] words) {
        Queue<Word> q = new LinkedList();
        int len = words.length;
        boolean[] visited = new boolean[len];
        q.add(new Word(begin, 0));
        
        while (!q.isEmpty()) {
            Word curr = q.poll();
            
            if (curr.word.equals(target)) {
                answer = curr.depth;
                return;
            }
            
            for (int i=0;i<len;i++) {
                if (visited[i] || !check(curr.word, words[i])) continue;
                visited[i] = true;
                q.add(new Word(words[i], curr.depth + 1));
            }
        }
    }
    
    boolean check(String str1, String str2) {
        int len = str1.length();
        int diff = 0;
        for (int i=0;i<len;i++) {
            if (str1.charAt(i) != str2.charAt(i)) ++diff;
        }
        return diff == 1;
    }
}

class Word {
    String word;
    int depth;
    
    public Word(String word, int depth) {
        this.word = word;
        this.depth = depth;
    }
}