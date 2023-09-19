import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        // queue1와 queue2 를 실제 큐 자료형 변수에 넣어준다.
        Queue<Long> q1 = new LinkedList();
        Queue<Long> q2 = new LinkedList();
        
        // queue1 의 합 - queue2 의 합
        long diff = 0;
        int len = queue1.length;
        
        for (int i=0;i<len;i++) {
            diff += queue1[i];
            diff -= queue2[i];
            
            q1.add((long) queue1[i]);
            q2.add((long) queue2[i]);
        }
        
        // num 은 q1->q2 또는 q2->q1 각 숫자를 옮길 때 임시로 저장할 변수
        long num;
        // diff 가 0이 될 때까지
        while (diff != 0) {
            // 각 한바퀴씩 돌았음에도 답이 나오지 않았다면 못구하는 것이니까 -1 반환
            if (answer > len * 2) return -1;
            // diff 가 0보다 크면서(q1 > q2) q1 에 아직 값이 남아있을 동안
            while (diff > 0 && !q1.isEmpty()) {
                // q1 에서 하나씩 꺼내 q2에 넘겨주고 diff(차이값)를 갱신한다.
                num = q1.poll();
                diff -= num * 2;
                q2.add(num);
                ++answer;
            }
            
            // diff 가 0보다 작으면서(q1 < q2) q2 에 아직 값이 남아있을 동안
            while (diff < 0 && !q2.isEmpty()) {
                // q2 에서 하나씩 꺼내 q1에 넘겨주고 diff(차이값)를 갱신한다.
                num = q2.poll();
                diff += num * 2;
                q1.add(num);
                ++answer;
            }
        }
        
        return answer;
    }
}