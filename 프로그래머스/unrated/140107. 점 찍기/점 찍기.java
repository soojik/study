class Solution {
    /*
    x^2 + y^2 <= d^2
    y^2 <= d^2 - x^2
    y <= Math.sqrt(d^2 - x^2)
    이 식을 이용해 x축을 0부터 d까지 k칸씩 이동하며 해당 x축에서 원점으로부터 d 이하로 떨어진 점 갯수를 answer에 더한다.
    */
    public long solution(int k, int d) {
        long answer = 0;
        
        long d2 = (long) d*d;
        
        for (long i=0;i<=d;i+=k) {
            answer += (long) Math.sqrt(d2 - i*i) / k + 1;
        }
        
        return answer;
    }
}