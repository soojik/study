import java.util.*;

class Solution {
    List<int[]> list = new ArrayList();
    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        int[][] answer = new int[list.size()][2];
        int idx = 0;
        for (int[] l : list) {
            answer[idx++] = new int[]{l[0], l[1]};
        }
        
        return answer;
    }
    
    void hanoi(int n, int 출발지, int 경유지, int 도착지) {
        if (n == 1) {
            list.add(new int[]{출발지, 도착지});
            return;
        }
        hanoi(n-1, 출발지, 도착지, 경유지);
        list.add(new int[]{출발지, 도착지});
        hanoi(n-1, 경유지, 출발지, 도착지);
    }
}