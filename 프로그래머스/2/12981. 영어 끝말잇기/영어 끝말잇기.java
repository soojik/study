import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int round = 0;
        int[] answer = {0, 0};
        Set<String> set = new HashSet();

        int len = words.length;
        int num;
        for (int i=0;i<len;i++) {
            num = i % n + 1;
            if (num == 1) ++round;
            
            if (i > 0 && (set.contains(words[i])
                    || words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0))) {
                return new int[]{num, round};
            }
            else set.add(words[i]);
        }

        return new int[]{0, 0};
    }
}