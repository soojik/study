class Solution {
    public String solution(String number, int k) {
        int len = number.length();
        
        // String number -> int[] 변환
        int[] nums = new int[len];
        for (int i=0;i<len;i++) nums[i] = number.charAt(i) - '0';
        
        StringBuilder answer = new StringBuilder("");
        
        // 주어진 number 에서 idx(시작점) ~ 일정범위만큼 조사해 얻은 최댓값을 answer 에 계속 더하는 식으로 정답을 구한다.
        int idx = 0;
        // number 길이에서 k 를 뺀 만큼의 길이가 나와야하므로 탐색(시작점)도 len-k 까지만 진행한다.
        for (int i=0;i<len-k;i++) {
            int max = 0;
            for (int j=idx;j<=i+k;j++) {
                // 최댓값 업데이트 후, 다음 탐색 시작점은 현재 탐색한 곳 다음 인덱스로 지정해준다.
                if (max < nums[j]) {
                    max = nums[j];
                    idx = j + 1;
                }
            }
            // 최댓값 answer 에 더해준다.
            answer.append(max);
        }
        
        return answer.toString();
    }
}