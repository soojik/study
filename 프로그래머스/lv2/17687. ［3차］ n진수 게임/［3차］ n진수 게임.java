

class Solution {
    StringBuilder allNum = new StringBuilder();
    StringBuilder answer = new StringBuilder();
    public String solution(int n, int t, int m, int p) {
        int idx = 0;
        
        int num = 0;
        while (allNum.length() <= m*t) {
            addNum(num++, n);
        }
        
        while (idx < t) {
            answer.append(allNum.charAt(idx * m + p - 1));
            ++idx;
        }
        
        return answer.toString();
    }
    
    public void addNum(int num, int n) {
        StringBuilder sb = new StringBuilder();
        
        if (num == 0) {
            allNum.append(0);
            return;
        }
        while (0 < num) {
            if (10 <= num % n && num % n <= 15) {
                sb.append((char) (num%n+55));
                num /= n;
                continue;
            }
            sb.append(num%n);
            num /= n;
        }
        
        allNum.append(sb.reverse());
    }
}