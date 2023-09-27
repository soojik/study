import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        // 2. col번째 컬럼값 기준으로 오름차순, 같은 값에 대해서는 기본키에 대해 내림차순 정렬
        Arrays.sort(data, (int[] d1, int[] d2) -> (d1[col-1] == d2[col-1]) ? d2[0] - d1[0] : d1[col-1] - d2[col-1]);
        
        // 4. S_row_begin 부터 S_row_end까지 XOR 값을 업데이트해준다.
        for (int i=row_begin;i<=row_end;i++) {
            int tmp = 0;
            for (int d : data[i-1]) {
                tmp += d % i;
            }
            answer ^= tmp;
        }
        
        
        return answer;
    }
}