class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        while (0 < a && 0 < b) {
            ++answer;
            if (a % 2 == 1) {
                ++a;
            }
            a /= 2;
            if (b % 2 == 1) {
                ++b;
            }
            b /= 2;
            
            if (a == b) return answer;
        }
        
        return answer;
    }
}