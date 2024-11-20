import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        int N = msg.length();
        List<Integer> list = new ArrayList();
        
        Map<String, Integer> map = new HashMap();
        for (char c='A';c<='Z';c++) map.put(""+c, c-'A'+1);
        
        StringBuffer sb = new StringBuffer();
        int last_idx = 27;
        int idx = 0;
        
        for (int i=0;i<N;i++) {
            sb = new StringBuffer();
            
            int longest_word_idx = 0;
            for (int j=i;j<N;j++) {
                sb.append(msg.charAt(j));
                if (map.containsKey(sb.toString())) {
                    longest_word_idx = map.get(sb.toString());
                    if (j == N - 1) i = j;
                    continue;
                }
                i = j - 1;
                break;
            }
            map.put(sb.toString(), last_idx++);
            list.add(longest_word_idx);
        }
        
        answer = new int[list.size()];
        idx = 0;
        for (Integer i : list) answer[idx++] = i;
        
        return answer;
    }
}