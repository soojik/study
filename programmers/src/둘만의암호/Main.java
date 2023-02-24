package 둘만의암호;

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();

        System.out.println(s.solution("aukks", "wbqd", 5));
    }

}

class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] skips = new boolean[26];

        int skip_len = skip.length();
        for (int i=0;i<skip_len;i++) {
            skips[skip.charAt(i) - 'a'] = true;
        }

        StringBuilder non_skip = new StringBuilder();
        for (int i=0;i<26;i++) {
            if (!skips[i]) non_skip.append((char)('a'+i));
        }

        int non_len = non_skip.length();

        StringBuilder ans = new StringBuilder();
        int s_len = s.length();
        for (int i=0;i<s_len;i++) {
            char now = s.charAt(i);

            for (int j=0;j<non_len;j++) {
                if (now == non_skip.charAt(j)) {
                    if (j+index >= non_len) {
                        ans.append(non_skip.charAt((j+index)%non_len));
                    } else {
                        ans.append(non_skip.charAt(j+index));
                    }
                    break;
                }
            }
        }

        return ans.toString();
    }
}