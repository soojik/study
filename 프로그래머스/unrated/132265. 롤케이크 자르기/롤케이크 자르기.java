class Solution {
    /*
    모든 토핑을 처음에 형에게 준 후, 하나씩 동생에게 주며 둘의 토핑 종류 개수가 같아질 때마다 answer 를 1씩 증가시킨다.
    */
    public int solution(int[] topping) {
        int answer = 0;
        
        // 형, 동생이 각자 가진 토핑 정보를 가진 배열
        // older[토핑 번호] = 토핑 개수
        int[] older = new int[10001];
        int[] younger = new int[10001];
        
        int ocnt = 0, ycnt = 0;
        
        // 처음에 모든 토핑을 형에게 몰아준다.
        for (int t : topping) {
            if (older[t] == 0) ++ocnt;
            ++older[t];
        }
        
        // 토핑을 하나씩 순회하며 동생에게 주는데 만약 해당 토핑을 동생에게 넘겨준 후, 남은 것이 없다면 ocnt를 1 감소시킨다.
        for (int t : topping) {
            // 26 ~ 29 형으로부터 동생에게 토핑을 하나씩 넘겨주도록 동작
            --older[t];
            if (older[t] == 0) --ocnt;
            if (younger[t] == 0) ++ycnt;
            ++younger[t];
            // 동생에게 넘겨준 후, 형과 동생의 토핑 종류 개수를 비교
            if (ocnt == ycnt) {
                ++answer;
            }
        }
        
        return answer;
    }
}