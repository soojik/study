import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // e를 기준으로 오름차순 정렬하고, e가 같다면 s를 기준으로 오름차순 정렬
        Arrays.sort(targets, (int[] t1, int[] t2) -> {
            return (t1[1] == t2[1]) ? t1[0] - t2[0] : t1[1] - t2[1];
        });
        
        int last = 0;
        
        // 정렬된 배열을 돌면서 가장 뒤에 둘 수 있는 요격 미사일부터 두고, 그 후의 폭격 미사일이 요격 미사일 범위 안에 들어오는지 확인
        // 안들어온다면 가장 가까이 있는 미사일(last)을 업데이트
        for (int[] t : targets) {
            if (last == 0 || last < t[0]) {
                last = t[1] - 1;
                ++answer;
            }
        }
        
        return answer;
    }
}