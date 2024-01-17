class Solution {
    int[] answer = new int[11];
    int max = 0;
    public int[] solution(int n, int[] info) {
        comb(info, new int[11], 0, n);
        if (max == 0) return new int[]{-1};
        
        return answer;
    }
    
    // 전보다 더 낮은 점수를 많이 갖는지
    public boolean isBetterThanLast(int[] last, int[] curr) {
        for (int i=10;i>=0;i--) {
            if (last[i] < curr[i]) return true;
            else if (curr[i] < last[i]) return false;
        }
        return false;
    }
    
    public void setAnswer(int[] rinfo) {
        for (int i=0;i<=10;i++) answer[i] = rinfo[i];
    }
    
    // 점수차 구하는 메서드
    public int getScoreDiff(int[] ainfo, int[] rinfo) {
        int diff = 0;
        for (int i=0;i<=10;i++) {
            if (ainfo[i] < rinfo[i]) diff += (10 - i);
            else if (rinfo[i] < ainfo[i]) diff += (i - 10);
        }
        
        return diff;
    }
    
    public void comb(int[] ainfo, int[] rinfo, int idx, int depth) {
        // 쏠 화살이 없거나 모든 과녁을 돌았다면 
        if (depth == 0 || idx == 11) {
            rinfo[10] = depth;
            // 큰 점수차?
            int diff = getScoreDiff(ainfo, rinfo);
            if (max < diff) {
                max = diff;
                setAnswer(rinfo);
            }
            // 같은 점수이면서 전 점수보다 낮은 점수가 많다면
            else if (max == diff && isBetterThanLast(answer, rinfo)) {
                // 업데이트
                setAnswer(rinfo);
            }
            return;
        }
        
        // 현 과녁에는 아무것도 안쏘고 넘어감
        comb(ainfo, rinfo, idx+1, depth);
        // 현 과녁에 어피치보다 한발 더 쏨
        // 그러려면 info[idx] 보다 화살(depth)이 많아야만
        if (ainfo[idx] < depth) {
            rinfo[idx] = ainfo[idx] + 1;
            comb(ainfo, rinfo, idx+1, depth - rinfo[idx]);
            // 다음 탐색을 위해 원상태로 복귀
            rinfo[idx] = 0;
        }
    }
}