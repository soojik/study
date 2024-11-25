import java.util.*;

class Solution {
    int[] ryan = new int[11];
    int[] answer = new int[11];
    int diff = 0;
    public int[] solution(int n, int[] info) {
        
        func(0, n, info);
        if (diff == 0) return new int[]{-1};
        
        return answer;
    }
    
    // 점수차
    int get_diff(int[] apeach) {
        int a_cnt = 0, r_cnt = 0;
        for (int i=0;i<=10;i++) {
            if (ryan[i] <= apeach[i]) {
                if (apeach[i] == 0) continue;
                a_cnt += (10 - i);
                continue;
            }
            r_cnt += (10 - i);
        }
        
        return r_cnt - a_cnt;
    }
    
    // ryan이 answer보다 더 낮은 점수 많은지
    boolean is_more_qualified() {
        for (int i=10;i>=0;i--) {
            if (ryan[i] < answer[i]) return false;
            else if (ryan[i] > answer[i]) return true;
        }
        return false;
    }
    
    void func(int target, int left_arrows, int[] apeach) {
        if (target == 11 || left_arrows == 0) {
            ryan[10] = left_arrows;
            int curr_diff = get_diff(apeach);
            if (diff < curr_diff) {
                for (int i=0;i<=10;i++) answer[i] = ryan[i];
                diff = curr_diff;
            }
            // 낮은 점수가 더 많을 경우, answer 업데이트
            else if (diff == curr_diff && is_more_qualified()) {
                for (int i=0;i<=10;i++) answer[i] = ryan[i];
            }
            return;
        }
        
        // target 점수에서 아예 안맞출경우
        func(target + 1, left_arrows, apeach);
        
        // 맞출 경우
        if (apeach[target] < left_arrows) {
            ryan[target] = apeach[target] + 1;
            func(target + 1, left_arrows - ryan[target], apeach);
            ryan[target] = 0;
        }
    }
}