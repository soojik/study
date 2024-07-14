import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet();
    public int solution(String numbers) {
        combi_num(0, 0, new boolean[numbers.length()], numbers);
        
        return set.size();
    }
    
    public void combi_num(int idx, int num, boolean[] visited, String numbers) {
        int len = numbers.length();
        if (idx == len) {
            if (check(num)) set.add(num);
            return;
        }
        
        for (int i=0;i<len;i++) {
            if (visited[i]) continue;
            visited[i] = true;
            combi_num(idx + 1, num * 10 + (numbers.charAt(i) - '0'), visited, numbers);
            visited[i] = false;
            combi_num(idx + 1, num, visited, numbers);
        }
    }
    
    public boolean check(int num) {
        if (num < 2) return false;
        for (int i=2;i<=Math.sqrt(num);i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}