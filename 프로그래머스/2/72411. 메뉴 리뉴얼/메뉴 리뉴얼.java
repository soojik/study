import java.util.*;

class Solution {
    HashMap<String, Integer> combi = new HashMap(); // {코스요리 조합, 주문 횟수}
    HashMap<Character, Integer> menu_cnt = new HashMap(); // {단품 요리, 주문 휫수}
    boolean[] visit;
    int[] max; // max[i]는 i길이의 코스 중 가장 큰 주문 횟수
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList();
        
        int len = course.length;
        max = new int[11];
        
        // 단품 메뉴 주문 횟수(2번 이상인 메뉴만 포함이기때문)
        for (String order : orders) {
            for (int i=0;i<order.length();i++) menu_cnt.put(order.charAt(i), menu_cnt.getOrDefault(order.charAt(i), 0) + 1);
        }
        
        // 모든 주문에 대해
        for (String order : orders) {
            visit = new boolean[order.length()];
            for (int i=0;i<len;i++) {
                // 모든 조합의 나온 횟수 구하기
                // 정렬 후 넘겨줘서 MX, XM 같이 같은 코스를 헷갈려하지 않도록
                combination(getSortedStr(order), 0, course[i], "");
            }
        }
        
        List<String> keys = new ArrayList(combi.keySet());
        for (int i=0;i<course.length;i++) {
            for (String key : keys) {
                if (2 <= max[course[i]] && key.length() == course[i] && max[course[i]] == combi.get(key)) {
                    answer.add(key);
                }
            }
        }
        Collections.sort(answer);
        
        return answer;
    }
    
    /**
    order: 주문 항목
    idx: 탐색할 문자 인덱스
    target_count: 만들 코스 요리의 길이 
    lastCombi: 만들어온 코스 조합
    */
    public void combination(String order, int idx, int target_count, String lastCombi) {
        // order 문자 끝까지 탐색했을때
        if (idx == order.length()) {
            // 만들 코스 요리와 길이가 같다면
            if (target_count == lastCombi.length()) {
                // 해당 코스 요리(lastCombi)의 주문 횟수에 1 증가
                combi.put(lastCombi, combi.getOrDefault(lastCombi, 0) + 1);
                // 현재 코스 요리의 주문 횟수가 같은 길이의 코스 요리 중 가장 많이 주문됐다면 max 업데이트
                max[target_count] = Math.max(max[target_count], combi.get(lastCombi));
            }
            return;
        }
        
        // 만약 현재 단품 요리(order.charAt(idx))가 2번 이상 주문되었다면
        if (2 <= menu_cnt.get(order.charAt(idx))) {
            // 포함했을 때 경우도 탐색
            combination(order, idx+1, target_count, lastCombi+order.charAt(idx));
        }
        
        // 모든 경우에 현재 요리를 뺀 경우도 탐색
        combination(order, idx+1, target_count, lastCombi);
    }
    
    String getSortedStr(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}