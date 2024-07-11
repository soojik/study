import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<Integer> ans = new ArrayList();
        while (n >= 1) {
            ans.add((int)(n%10));
            n /= 10;
        }
        int[] answer = new int[ans.size()];
        int idx = 0;
        for (int i : ans) answer[idx++] = i;
        return answer;
    }
}