class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        
        for (int i=0;i<s.length();i++) {
            answer = Math.max(answer, Math.max(longestPalindromeLength(s, i, true),
                              longestPalindromeLength(s, i, false))
                             );
        }

        return answer;
    }
    
    // isOdd로 길이가 홀수인 팰린드롬 문자열, 짝수인 문자열을 구분해서 찾아낸다.
    int longestPalindromeLength(String s, int mid, boolean isOdd) {
        int start, end;
        if (isOdd) {
            start = end = mid;
        }
        else {
            start = mid;
            end = mid + 1;
        }
        
        while (0 <= start && end < s.length() && s.charAt(start) == s.charAt(end)) {
            --start;
            ++end;
        }
        
        return end - start - 1;
    }
}