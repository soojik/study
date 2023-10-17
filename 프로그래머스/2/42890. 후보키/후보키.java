import java.util.*;

class Solution {
    HashSet<String> answer = new HashSet(); // 후보키 조합을 넣을 HashSet
    int student_size; // 튜플 크기
    int column_size; // 컬럼 크기
    
    HashSet<String> set = new HashSet(); // void dfs 에서 사용할 유일성을 만족하는지 여부를 판단할 HashSet 변수
    public int solution(String[][] relation) {
        
        student_size = relation.length;
        column_size = relation[0].length;
        
        for (int i=1;i<=column_size;i++) {
            // 1부터 주어진 속성 갯수 크기만큼의 키 조합을 만들어서 후보키 조건을 만족하는지 검사한다.
            dfs(relation, 0, i, new boolean[column_size]);
        }
        
        return answer.size();
    }
    
    /*
    key_cnt: 이제까지 더해온 키 갯수
    target_key_cnt: 현재 탐색으로 만들 후보키 조합의 목표 크기
    visit: 탐색 진행하며 이미 탐색한 키는 건너뛰기 위한 방문 배열
    */
    public void dfs (String[][] relation, int key_cnt, int target_key_cnt, boolean[] visit) {
        // 탐
        if (key_cnt == target_key_cnt) {
            set = new HashSet();
            String keySet = "";
            for (String[] r : relation) {
                StringBuilder sb = new StringBuilder();
                for (int i=0;i<column_size;i++) {
                    if (visit[i]) {
                        sb.append(r[i]);
                        keySet += i;
                    }
                }
                set.add(sb.toString());
            }
            // 해당 후보키의 후보가 유일성을 만족하는지 (set.size() == student_size) 여부로 검사
            if (set.size() == student_size) {
                // 현재 keySet에 있는 키들의 조합이 다른 후보키와 같은지 검사해서 같다면 이제까지 탐색한 keySet은 최소성을 만족하지 않으므로 answer에 더하지 않는다.
                int keySetLen = keySet.length();
                for (String a : answer) {
                    int cnt = 0;
                    for (int i=0;i<keySetLen;i++) 
                        if (a.contains(keySet.charAt(i)+"")) ++cnt;
                    if (cnt == a.length()) return;
                }
                answer.add(keySet);
            }
            return;
        }
        
        for (int i=0;i<column_size;i++) {
            if (visit[i]) continue;
            visit[i] = true;
            dfs(relation, key_cnt+1, target_key_cnt, visit);
            visit[i] = false;
        }
    }
}