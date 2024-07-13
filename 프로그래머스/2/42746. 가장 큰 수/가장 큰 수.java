import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuffer answer = new StringBuffer();
        
        String[] str_arr = new String[numbers.length];
        int idx = 0;
        for (int n : numbers) str_arr[idx++] = Integer.toString(n);
        
        Arrays.sort(str_arr, new Comparator<String>() {
            @Override
            public int compare(String i1, String i2) {
                return (i2 + i1).compareTo(i1 + i2);
            }
        });
        
        for (String str : str_arr) answer.append(str);
        
        return answer.charAt(0) == '0' ? "0" : answer.toString();
    }
}