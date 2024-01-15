import java.util.*;

class Solution {
    int stoi(String s) {return Integer.parseInt(s);}
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        
        String cm = changeSharpToLower(m.toCharArray());
        
        /* 재생시간 높은순대로 정렬 */
        PriorityQueue<Musicinfo> pq = new PriorityQueue();
        
        int idx = 0;
        for (String info : musicinfos) {
            String[] splited = info.split(",");
            int playTime = strToMinute(splited[1]) - strToMinute(splited[0]);
            String wholeMusic = getWholeMusic(splited[3].toCharArray(), playTime);
            
            pq.add(new Musicinfo(playTime, splited[2], wholeMusic));
        }
        
        /* 정렬된 pq에서 꺼내서 */
        while (!pq.isEmpty()) {
            Musicinfo info = pq.poll();
            
            // 시작점이 될 수 있는 0 ~ ((info 길이) - (변환한 m 길이))
            for (int start=0;start<=info.notes.length() - cm.length();start++) {
                // 만약 현재 노래에서 start 인덱스 값이 원하는 음계의 시작과 같지 않다면 탐색하지 않고
                if (!(info.notes.charAt(start) == cm.charAt(0))) continue;
                
                // 만약 같다면
                boolean isValid = true;
                // 뒤에 완전히 같은 문자열이 오는지 확인
                for (int i=0;i<cm.length();i++) {
                    if (!(info.notes.charAt(i + start) == cm.charAt(i))) {
                        isValid = false;
                        break;
                    }
                }
                
                // 모두 같다고 판명되면 바로 이름 반환
                if (isValid) return info.name;
            }
        }
        
        return answer;
    }
    
    /* 재생 시간이 주어진 길이를 넘어가거나 짧다면 그에 맞게 길이를 조정해서 전체 음계 반환하는 메서드 */
    private String getWholeMusic(char[] notes, int playTime) {
        StringBuilder result = new StringBuilder();
        
        char[] changedNote = changeSharpToLower(notes).toCharArray();
        
        int note_len = changedNote.length;
        int note_cnt = 0;
        while (note_cnt < playTime) {
            result.append(changedNote[note_cnt % note_len]);
            ++note_cnt;
        }
        
        return result.toString();
    }
    
    /* 샵들어가있는 음계는 소문자로 변환하는 메서드 */
    private String changeSharpToLower(char[] notes) {
        
        StringBuilder result = new StringBuilder();
        for (int i=0;i<notes.length;i++) {
            char c = notes[i];
            if (i+1 < notes.length && notes[i+1] == '#') {
                c = Character.toLowerCase(notes[i]);
                ++i;
            }
            result.append(c);
        }
        
        return result.toString();
    }
    
    /* 몇분동안 재생되었는지 int로 변환할 메서드 */
    private int strToMinute(String str) {
        String[] tmp = str.split(":");
        return stoi(tmp[0]) * 60 + stoi(tmp[1]);
    }
}

class Musicinfo implements Comparable<Musicinfo> {
    int playTime;
    String name;
    String notes;
    
    public Musicinfo (int playTime, String name, String notes) {
        this.playTime = playTime;
        this.name = name;
        this.notes = notes;
    }
    
    /* 조건이 일치하는 음악이 여러 개일 때에는
    1. 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다.
    2. 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.*/
    public int compareTo(Musicinfo m) {
        return m.playTime - this.playTime;
    }
}