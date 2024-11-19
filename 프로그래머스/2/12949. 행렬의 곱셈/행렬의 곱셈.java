import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int len_r = arr1.length;
        int len_c = arr2[0].length;
        int[][] answer = new int[len_r][len_c];
        
        for (int i=0;i<len_r;i++) {
            for (int j=0;j<len_c;j++) {
                for (int k=0;k<arr2.length;k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}