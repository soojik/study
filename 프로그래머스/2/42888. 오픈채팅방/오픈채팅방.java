import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList();
        
        int len = record.length;
        Map<String, String> uid_name = new HashMap();
        for (int i=0;i<len;i++) {
            String[] cmd = record[i].split(" ");
            // System.out.println(cmd[0]);
            
            if (cmd[0].equals("Enter")) {
                uid_name.put(cmd[1], cmd[2]);
                list.add(cmd[1] + " 입장");
            }
            else if (cmd[0].equals("Change")) {
                uid_name.put(cmd[1], cmd[2]);
            }
            else {
                list.add(cmd[1] + " 퇴장");
            }
        }
        
        String[] answer = new String[list.size()];
        int idx = 0;
        for (String msg : list) {
            String[] splited = msg.split(" ");
            if (splited[1].equals("입장")) {
                answer[idx++] = uid_name.get(splited[0]) + "님이 들어왔습니다.";
                continue;
            }
            answer[idx++] = uid_name.get(splited[0]) + "님이 나갔습니다.";
        }
        
        return answer;
    }
}