import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int len = order.length;
        // 후입선출로 동작하는 보조 컨테이너 벨트
        Stack<Integer> subContainer = new Stack();
        
        // orderIdx 는 현재 꺼내야하는 택배 번호
        int orderIdx = 0;
        
        // 컨테이너 벨트에서 순서대로 나오는 택배 번호
        for (int i=0;i<len;i++) {
            // 일단 보조 컨테이너로 옮긴 후
            subContainer.add(i+1);
            
            // 보조 컨테이너에서 주문 순서가 맞는대로 다 꺼낸다.
            while (!subContainer.isEmpty() && subContainer.peek() == order[orderIdx]) {
                ++orderIdx;
                subContainer.pop();
            }
        }
        
        // 다음 찾을 주문 차례 인덱스가 현재까지 찾은 택배 수와 일치하므로 출력
        return orderIdx;
    }
}