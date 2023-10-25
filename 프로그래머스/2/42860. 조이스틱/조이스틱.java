class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int index;
        int move = len - 1;
        
        for (int i=0;i<len;i++) {
            char changeTo = name.charAt(i);
            answer += Math.min(changeTo - 'A', 'Z' - changeTo + 1);
            
            // 다음 차례부터 시작해서 뒤에 오는 연속된 A 갯수 세기
            index = i + 1;
            while (index < len && name.charAt(index) == 'A') ++index;
            
            // i * 2 + len - index 는 인덱스 기준 [i -> 0 -> len-1 -> index] 로 가는 방법
            // (len - index) * 2 + i 는 인덱스 기준 [index -> len-1 -> 0 -> i] 로 가는 방법
            // 그리고 기존에 앞에서 업데이트된 move 와 비교해 적게 움직이는 방법으로 계속 업데이트한다.
            move = Math.min(move, Math.min(i * 2 + len - index, (len - index) * 2 + i));
        }
        
        return answer + move;
    }
}