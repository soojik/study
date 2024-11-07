import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        List<File> list = new ArrayList();
        
        for (String f : files) {
            // HEAD, NUMBER, TAIL
            String HEAD = "";
            String NUMBER = "";
            String TAIL = "";
            
            int idx = 0;
            for (idx=0;idx<f.length();idx++) {
                if (Character.isDigit(f.charAt(idx))) break;
                HEAD += f.charAt(idx);
            }
            
            for (;idx<f.length();idx++) {
                if (!Character.isDigit(f.charAt(idx))) break;
                NUMBER += f.charAt(idx);
            }
            
            for (;idx<f.length();idx++) {
                TAIL += f.charAt(idx);
            }
            
            list.add(new File(HEAD, NUMBER, TAIL));
        }
        
        Collections.sort(list);
        int idx = 0;
        for (File f : list) {
            answer[idx++] = f.HEAD + f.NUMBER + f.TAIL;
        }
        
        return answer;
    }
}

class File implements Comparable<File> {
    String HEAD;
    String NUMBER;
    String TAIL;
    
    public File (String HEAD, String NUMBER, String TAIL) {
        this.HEAD = HEAD;
        this.NUMBER = NUMBER;
        this.TAIL = TAIL;
    }
    
    @Override
    public int compareTo(File other) {
        if (this.HEAD.toLowerCase().equals(other.HEAD.toLowerCase())) {
            return Integer.parseInt(this.NUMBER) - Integer.parseInt(other.NUMBER);
        }
        return this.HEAD.toLowerCase().compareTo(other.HEAD.toLowerCase());
    }
    
    @Override
    public String toString() {
        return HEAD + " " + NUMBER + " " + TAIL;
    }
}