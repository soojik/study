import java.util.LinkedList;
import java.util.Queue;

class Solution {
    Queue<Truck> onBridge = new LinkedList();
    int totalWeight = 0;
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 새 차가 들어갈 시간 업데이트
        int answer = 0;
        
        // 트럭 가리키는 인덱스
        int truck_idx = 0;
        while (truck_idx < truck_weights.length) {
            // 현재 가리키는 트럭이 다리에 올라갈 수 있다면
            if (totalWeight + truck_weights[truck_idx] <= weight) {
                // {무게, 나오는 시간} 으로 다리 위에 올려주고
                onBridge.add(new Truck(truck_weights[truck_idx], answer + bridge_length));
                // 다리 위 트럭 무게 합산 값 업데이트
                totalWeight += truck_weights[truck_idx++];
                // 계속해서 다리 위에 올라올 경우를 위해 answer 1 증가
                ++answer;
            }
            
            // 다리 위에 있는 트럭무게 + 현재 트럭이 초과한다면 맨 앞 트럭 빠져나간 후부터 탐색하도록
            else {
                // 맨 앞 트럭 빠져나감
                Truck t = onBridge.poll();
                totalWeight -= t.weight;
                // 다음 차 들어올 시간 업데이트(answer) 해주는데 해당 차 나간 시간과 가장 최근 올라온 차가 올라간 시간 중 더 나중인 값으로 업데이트
                answer = Math.max(answer, t.endTime);
            }
        }
        
        // 다리 위 남은 차에서 가장 나중에 나가는 차의 끝나는 시간으로 answer 업데이트
        while (!onBridge.isEmpty()) {
            System.out.println(onBridge.peek());
            if (onBridge.size() == 1) answer = onBridge.poll().endTime;
            
            onBridge.poll();
        }
        
        // 나가는데 1초이므로 1 증가
        return answer + 1;
    }
}

class Truck {
    int weight;
    int endTime;
    
    @Override
    public String toString() {
        return "weight: " + weight + ", endTime: " + endTime;
    }
    
    public Truck(int weight, int endTime) {
        this.weight = weight;
        this.endTime = endTime;
    }
}