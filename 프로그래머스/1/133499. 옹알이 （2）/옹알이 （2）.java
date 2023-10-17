import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int result = babbling.length;
        
        String[] strings = {"aya", "ye", "woo", "ma"};
        
        // 할 수 있는 발음 모두를 발음의 인덱스로 치환해서
        // 1. 문자가 있거나
        // 2. 같은 숫자가 두개 붙어있다면
        // 발음할 수 없는 단어니까 result 에서 1 감소시킨다.
        List<String> replacedBabbling = new ArrayList();
        
        int len = babbling.length;
        for (int i=0;i<len;i++) {
            int str_len = babbling[i].length();
            for (int j=0;j<4;j++) {
                babbling[i] = babbling[i].replace(strings[j], j+"");
            }
            replacedBabbling.add(babbling[i]);
        }
        
        for (String b : replacedBabbling) {
            int str_len = b.length();
            char[] char_arr = b.toCharArray();
            
            boolean flag = true;
            for (int i=0;i<str_len&&flag;i++) {
                if (i == 0) {
                    if (!Character.isDigit(char_arr[i])) {
                        --result;
                        flag = false;
                    }
                    continue;
                }
                
                if (!Character.isDigit(char_arr[i]) || char_arr[i-1] == char_arr[i]) {
                    --result;
                    flag = false;
                }
            }
        }
        
        return result;
    }
}