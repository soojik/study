import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int targets_len = targets.length;
        int[] answer = new int[targets_len];
        
        HashMap<Character, Integer> map = new HashMap();
        
        for (String s : keymap) {
            int len = s.length();
            for (int i=0;i<len;i++) {
                map.put(s.charAt(i), Math.min(map.getOrDefault(s.charAt(i), Integer.MAX_VALUE), i + 1));
            }
        }
        
        for (int i=0;i<targets_len;i++) {
            int target_len = targets[i].length();
            int cnt = 0;
            for (int j=0;j<target_len;j++) {
                char curr = targets[i].charAt(j);
                if (!map.containsKey(curr)) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += map.getOrDefault(curr, 0);
            }
        }
        
        return answer;
    }
}