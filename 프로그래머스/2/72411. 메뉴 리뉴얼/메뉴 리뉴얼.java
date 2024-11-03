import java.util.*;

class Solution {
    // {조합, 나온 수}
    HashMap<String, Integer> map = new HashMap();
    int len_order, len_course;
    int max = 0;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        List<String> list = new ArrayList();
        
        len_order = orders.length;
        len_course = course.length;
        
        for (int i=0;i<len_course;i++) {
            map = new HashMap();
            max = 0;
            for (int j=0;j<len_order;j++) {
                combi(orders[j], course[i], -1, "");
            }
            // System.out.println(course[i] + " " + max + " " + map);
            for (String key : map.keySet()) {
                if (map.get(key) == max && 2 <= max) {
                    list.add(key);
                    // System.out.println(course[i] + " " + list);
                }
            }
        }
        
        Collections.sort(list);
        answer = new String[list.size()];
        int idx = 0;
        for (String str : list) answer[idx++] = str;
        
        return answer;
    }
    
    void combi(String order, int course, int idx, String 조합) {
        if (조합.length() == course) {
            char[] arr = 조합.toCharArray();
            Arrays.sort(arr);
            // System.out.println(Arrays.toString(arr));
            String sorted_조합 = "";
            for (char c : arr) sorted_조합 += c;
            // String str = 조합.toString();
            int cnt = map.getOrDefault(sorted_조합, 0) + 1;
            map.put(sorted_조합, cnt);
            max = Math.max(cnt, max);
            return;
        }
        
        for (int i=idx + 1;i<order.length();i++) {
            combi(order, course, i, 조합 + order.charAt(i));
        }
    }
}