import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int len = truck_weights.length;
        
        Queue<int[]> on_bridge = new LinkedList();
        int on_bridge_weight = 0;
        int time = 0;
        int i = 0;
        while (i < len) {
            ++time;
            
            // 다리 위 트럭 내리기
            if (!on_bridge.isEmpty() && time - on_bridge.peek()[1] >= bridge_length) {
                on_bridge_weight -= on_bridge.poll()[0];
            }
            
            // 다리에 트럭 올리기
            int t = truck_weights[i];
            if (on_bridge_weight + t <= weight) {
                on_bridge.add(new int[]{t, time});
                on_bridge_weight += t;
                ++i;
            }
        }
        
        // 마지막 트럭 빠져나가는 시간
        return time + bridge_length;
    }
}