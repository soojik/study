import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> q_min = new PriorityQueue<>((i1, i2) -> i1 - i2);
        PriorityQueue<Integer> q_max = new PriorityQueue<>((i1, i2) -> i2 - i1);
        
        for (String o : operations) {
            int num = Integer.parseInt(o.split(" ")[1]);
            char cmd = o.charAt(0);
            
            if (cmd == 'I') {
                q_min.add(num);
                q_max.add(num);
                continue;
            }
            if (cmd == 'D') {
            
                if (q_min.isEmpty() || q_max.isEmpty()) continue;
                
                if (num == -1) {
                    int min = q_min.poll();
                    q_max.remove(Integer.valueOf(min));
                    continue;
                }
                int max = q_max.poll();
                q_min.remove(Integer.valueOf(max));
            }
        }
        
        return new int[]{q_max.isEmpty() ? 0 : q_max.poll(), q_min.isEmpty() ? 0 : q_min.poll()};
    }
}