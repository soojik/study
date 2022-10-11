import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<Integer>();
        
        for (int n : arr)
            if (n%divisor == 0) answer.add(n);
        
        if (answer.size() == 0) answer.add(-1);
        
        Collections.sort(answer);
        
        return answer;
    }
}