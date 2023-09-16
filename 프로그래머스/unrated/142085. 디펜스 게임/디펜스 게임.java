import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int len = enemy.length;
        
        // 무적권이 라운드 수보다 많거나 같을 때는 모든 라운드를 막을 수 있으므로
        if (len <= k) return len;
        
        // enemy 를 순회하며 각 소모병사 수를 max 에 넣으면서 가장 큰 순서대로 정렬한다.
        PriorityQueue<Integer> max = new PriorityQueue((new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        }));
        
        int idx = 0;
        // 무적권을 모두 소모하면 중단
        while (idx < len) {
            // 현재 소모해야할 병사를 더해준다.
            max.add(enemy[idx]);
            // 소모 후
            n -= enemy[idx];
            // 0 미만이면서
            if (n < 0) {
                // 무적권이 있다면
                if (k > 0) {
                    // 이전에 나왔던 소모병사 중 가장 큰 값을 더해주고
                    n += max.poll();
                    // 무적권을 하나 사용한다.
                    --k;   
                }
                // 무적권이 없다면 idx 반환하고 탐색 종료
                else return idx;
            }
            // 다음 탐색 진행
            ++idx;
        }
        
        return idx;
    }
}