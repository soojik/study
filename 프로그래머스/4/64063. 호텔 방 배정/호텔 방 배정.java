import java.util.*;

class Solution {
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        Map<Long, Long> map = new HashMap();
        
        for (int i=0;i<room_number.length;i++) {
            long r = room_number[i];
            List<Long> need_to_update = new ArrayList();
            
            while (map.getOrDefault(r, 0L) != 0L) {
                need_to_update.add(r);
                r = map.get(r);
            }
            
            answer[i] = r;
            
            need_to_update.add(r);
            
            for (long room : need_to_update) {
                map.put(room, r + 1);
            }
        }
        
        return answer;
    }
}