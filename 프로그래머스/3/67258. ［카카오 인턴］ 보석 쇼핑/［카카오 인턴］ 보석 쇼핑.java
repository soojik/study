import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int N = gems.length;
        int[] answer = new int[]{1, N};
        Map<String, Integer> map = new HashMap();
        Set<String> set = new HashSet();
        for (String g : gems) set.add(g);
        int cnt = set.size();

        int start = 0;
        int end = 0;

        while (end < N) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            ++end;
            
            while (map.size() == cnt) {
                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                ++start;
                if (end - start < answer[1] - answer[0]) answer = new int[]{start, end};
            }
        }
        
        return answer;
    }
}