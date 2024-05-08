import java.util.*;
import java.lang.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        // HEAD, NUMBER, TAIL 로 나눠 FILE 객체로 만들어서 정렬 
        File[] file_arr = new File[files.length];
        int a_idx = 0;
        for (String f : files) {
            StringBuffer HEAD = new StringBuffer();
            char[] arr = f.toCharArray();
            int c_idx = 0;
            // 첫번째는 무조건 영문자니까 나오는 동안 모두 HEAD
            while (c_idx < f.length() && !('0' <= arr[c_idx] && arr[c_idx] <= '9')) {
                HEAD.append(arr[c_idx++]);
            }
            // 그 뒤로 나오는 모든 숫자는 NUMBER
            StringBuffer NUMBER = new StringBuffer();
            while (c_idx < f.length() && '0' <= arr[c_idx] && arr[c_idx] <= '9') {
                NUMBER.append(arr[c_idx++]);
            }
            // 나머지 전부 TAIL
            StringBuffer TAIL = new StringBuffer();
            while (c_idx < f.length()) {
                TAIL.append(arr[c_idx++]);
            }
            file_arr[a_idx++] = new File(HEAD.toString(), NUMBER.toString(), TAIL.toString());
        }
        a_idx = 0;
        
        Arrays.sort(file_arr);
        for (File f : file_arr) answer[a_idx++] = f.toString();
        
        return answer;
    }
}

class File implements Comparable<File> {
    String HEAD;
    String NUMBER;
    String TAIL;
    
    public File(String HEAD, String NUMBER, String TAIL) {
        this.HEAD = HEAD;
        this.NUMBER = NUMBER;
        this.TAIL = TAIL;
    }
    
    @Override
    public int compareTo(File f) {
        // HEAD 가 같으면
        if (this.HEAD.toLowerCase().equals(f.HEAD.toLowerCase())) {
            // NUMBER를 숫자로 데이터 형변환해 대소 비교
            return Integer.parseInt(this.NUMBER) - Integer.parseInt(f.NUMBER);
        }
        // HEAD 대소문자 기준 정렬
        return this.HEAD.toLowerCase().compareTo(f.HEAD.toLowerCase());
    }
    
    // 합쳐서 반환
    @Override
    public String toString() {
        return HEAD + NUMBER + TAIL;
    }
}