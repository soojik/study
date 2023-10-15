import java.util.*;

class Solution {
    int[][] m_cnt;
    int answer = Integer.MAX_VALUE;
    int mineral_len;
    int m_cnt_len;
    int tools_len = 0;
    public int solution(int[] picks, String[] minerals) {
        
        mineral_len = minerals.length;
        for (int i : picks) tools_len += i;
        
        // 갖고있는 곡괭이로 모두 못깰 경우를 위해 다 깰 수 있는만큼으로 배열을 잘라준다.
        // (곡괭이 갯수 * 5) 와 (캐야할 광석 갯수) 를 비교해 작은만큼으로 배열을 잘라주는데,
        // 5개씩 자를 것이기 때문에 결과적으로 m_cnt 크기는 [둘 중 작은 값을 5씩 쪼개서 나온 그룹 수][3(광석 종류)];
        m_cnt_len = (Math.min(mineral_len, tools_len * 5) % 5 == 0) ? Math.min(mineral_len, tools_len * 5) / 5 : Math.min(mineral_len, tools_len * 5) / 5 + 1;
        m_cnt = new int[m_cnt_len][3];
        
        for (int i=0;i<m_cnt_len;i++) {
            for (int j=0;j<5;j++) {
                if (mineral_len == i*5 + j) break;
                if (minerals[i*5 + j].equals("diamond")) m_cnt[i][0] += 1;
                if (minerals[i*5 + j].equals("iron")) m_cnt[i][1] += 1;
                if (minerals[i*5 + j].equals("stone")) m_cnt[i][2] += 1;
            }
        }
        
        dfs(picks, 0, 0);
        
        return answer;
    }
    
    public void dfs (int[] picks, int idx, int stemina) {
        // 광석 그룹 모두 탐색 완료했다면
        if (idx == m_cnt_len) {
            // 최솟값 업데이트
            answer = Math.min(stemina, answer);
            // 해당 경로로는 탐색 종료
            return;
        }
        
        // 3개의 곡괭이를 돌며
        for (int i=0;i<3;i++) {
            // 현재 속성의 곡괭이가 없다면 넘어간다.
            if (picks[i] == 0) continue;
            
            // useStemina 에 해당 곡괭이를 사용했을 때의 피로도를 저장한다.
            int useStemina = 0;
            if (i == 0) useStemina = m_cnt[idx][0] + m_cnt[idx][1] + m_cnt[idx][2];
            if (i == 1) useStemina = 5*m_cnt[idx][0] + m_cnt[idx][1] + m_cnt[idx][2];
            if (i == 2) useStemina = 25*m_cnt[idx][0] + 5*m_cnt[idx][1] + m_cnt[idx][2];
            
            // 현재 속성의 곡괭이 갯수를 하나 줄인다.
            --picks[i];
            // 다음 탐색을 진행한다.
            dfs(picks, idx+1, stemina + useStemina);
            // 다음 탐색을 위해 곡괭이 갯수를 복원한다.
            ++picks[i];
        }
    }
}