class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        int 나머지;
        while (storey > 0) {
            
            나머지 = storey % 10;
            storey /= 10;
            
            // 제일 마지막 수부터 5 이상이거나, 5일때 다음 숫자가 5보다 크거나 같으면 증가, 아니라면 감소하도록 한다.
            if (나머지 > 5 || (나머지 == 5 && storey % 10 >= 5)) {
                answer += (10 - 나머지);
                // 이때, 증가했을 때는 다음 10의 자리수에 1을 더해줘야하므로, 이미 마지막 숫자를 뗀 storey에 1을 증가하도록 한다.
                ++storey;
            }
            
            else answer += 나머지;
        }
        
        return answer;
    }
}