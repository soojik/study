import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        int N = elements.length;
        
        Set<Integer> set = new HashSet();
        
        for (int i=0;i<N;i++) {
            int sum = 0;
            for (int j=0;j<N;j++) {
                sum += elements[N <= i + j ? i + j - N : i + j];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}