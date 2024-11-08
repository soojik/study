import java.util.*;

class Solution {
    // J(A, B) -> 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값 (교 == 0 || 합 == 0) == 1
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // * 65536
        Map<String, Integer> map1 = new HashMap();
        Map<String, Integer> map2 = new HashMap();
        
        char c1, c2;
        for (int i=0;i<str1.length()-1;i++) {
            if (!Character.isAlphabetic(str1.charAt(i))) continue;
            c1 = Character.toLowerCase(str1.charAt(i));
            // for (int j=i+1;j<str1.length();j++) {
                if (!Character.isAlphabetic(str1.charAt(i+1))) continue;
                c2 = Character.toLowerCase(str1.charAt(i+1));
                String tmp = "" + c1 + c2;
                map1.put(tmp, map1.getOrDefault(tmp, 0) + 1);
            // }
        }
        
        for (int i=0;i<str2.length()-1;i++) {
            if (!Character.isAlphabetic(str2.charAt(i))) continue;
            c1 = Character.toLowerCase(str2.charAt(i));
                if (!Character.isAlphabetic(str2.charAt(i+1))) continue;
                c2 = Character.toLowerCase(str2.charAt(i+1));
                String tmp = "" + c1 + c2;
                map2.put(tmp, map2.getOrDefault(tmp, 0) + 1);
        }
        
        if (map1.size() == 0 && map2.size() == 0) return 65536;
        
        int 교집합 = 0;
        int 합집합 = 0;
        
        // 교집합
        for (String s : map1.keySet()) {
            if (0 < map2.getOrDefault(s, 0)) 교집합 += Math.min(map1.get(s), map2.get(s));
        }
        
        // 합집합
        Map<String, Integer> 합집합_map = new HashMap();
        for (String s : map1.keySet()) {
            합집합_map.put(s, map1.get(s));
        }
        for (String s : map2.keySet()) {
            합집합_map.put(s, Math.max(합집합_map.getOrDefault(s, 0), map2.get(s)));
        }
        for (String s : 합집합_map.keySet()) 합집합 += 합집합_map.get(s);
        
        return 교집합 * 65536 / 합집합;
    }
}