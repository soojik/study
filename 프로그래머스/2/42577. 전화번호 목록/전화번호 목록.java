import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        int idx = 0; // 접두어로서 다른 단어에 붙는지 확인할 단어를 순회하기 위한 인덱스 
        for (int i=1;i<phone_book.length;i++) {
            // 접두어로 다른 단어에 붙는지 확인: phone_book[idx]
            // 접두어가 있는지 확인할 대상: phone_book[i]
            // 만약 접두어가 비교대상보다 길거나, 접두어로 들어가지 않는다면
            if (phone_book[i].length() < phone_book[idx].length() || 
                !phone_book[i].startsWith(phone_book[idx])) {
                // 다음 접두어로 현재 단어(비교대상)를 지정 
                idx = i;
                continue;
            }
            // 위 조건에 걸리지 않는다면 접두어가 있다는 경우니까 false
            answer = false;
        }
        return answer;
    }
}