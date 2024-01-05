import java.util.*;

class Solution {
    static int stoi(String s) {return Integer.parseInt(s);}
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList();
        
        /* 약관 유효기간 <= (오늘 - 시작) (이면 파기해야할 문서)
        */
        String[] tmp;
        int today_y = stoi(today.substring(0, 4));
        int today_m = stoi(today.substring(5, 7));
        int today_d = stoi(today.substring(8, 10));
        
        HashMap<String, Integer> terms_to_day = new HashMap();
        for (String t : terms) {
            tmp = t.split(" ");
            // 달을 일 수로 바꿔 넣어주기
            terms_to_day.put(tmp[0], (stoi(tmp[1])) * 28);
        }
        
        int p_len = privacies.length;
        for (int i=0;i<p_len;i++) {
            String p = privacies[i];
            tmp = p.split(" ");
            // 시작 날짜
            int start_y = stoi(tmp[0].substring(0, 4));
            int start_m = stoi(tmp[0].substring(5, 7));
            int start_d = stoi(tmp[0].substring(8, 10));
            // 약관 종류
            String insurance = tmp[1];
            
            int calculate_until_today = (today_y - start_y) * 28 * 12 + (today_m - start_m) * 28 + (today_d - start_d);
            
            if (terms_to_day.get(insurance) <= calculate_until_today) answer.add(i + 1);
        }
        
        
        return answer.stream().mapToInt(integer -> integer).toArray();
    }
}