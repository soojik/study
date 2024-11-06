import java.util.*;

class Solution {
    int n;
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        
        n = arr.length;
        
        func(0, 0, n, arr);
        
        return answer;
    }
    
    public void func(int r, int c, int len, int[][] arr) {
        if (check(r, c, len, arr)) {
            ++answer[arr[r][c]];
            return;
        }
        
        func(r, c, len/2, arr);
        func(r+len/2, c, len/2, arr);
        func(r, c+len/2, len/2, arr);
        func(r+len/2, c+len/2, len/2, arr);
    }
    
    public boolean check(int r, int c, int len, int[][] arr) {
        int num = arr[r][c];
        for (int i=r;i<r+len && i<n;i++) {
            for (int j=c;j<c+len && j<n;j++) {
                if (num == arr[i][j]) continue;
                return false;
            }
        }
        
        return true;
    }
}