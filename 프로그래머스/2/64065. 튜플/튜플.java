import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        s = s.replace("{", "");
        s = s.replace("}", "");
        s = s.replace(",", " ");

        StringTokenizer st = new StringTokenizer(s);
        
        Map<Integer, Integer> map = new HashMap();
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<int[]> list = new ArrayList();
        for (Integer k : map.keySet()) {
            list.add(new int[]{k, map.get(k)});
        }
        
        list.sort((a, b) -> b[1] - a[1]);
        
        answer = new int[list.size()];
        int idx = 0;
        for (int[] arr : list) answer[idx++] = arr[0];
        
        return answer;
    }
}