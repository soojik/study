class Solution {
    public int solution(int sticker[]) {
        // 크기가 1이나 2라면 스티커 중 바로 최댓값을 반환
        if (sticker.length == 1) return sticker[0];
        if (sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        int answer = 0;

        // [i][j] : i에서 시작한 경우, j까지의 스티커까지 탐색했을 때 얻을 수 있는 최댓값
        int[][] dp = new int[3][sticker.length];
        // 방문 여부 체크
        boolean[][] visit = new boolean[3][sticker.length];
        
        // 초기값 설정
        dp[0][0] = sticker[0];
        dp[1][1] = sticker[1];
        dp[2][2] = sticker[2];
        
        // 스티커를 뗄 수 있는 경우는 현재 자리에서 (한칸은 찢어지니) 두칸, 세칸 뒤에 있는 경우
        for (int startAt=0;startAt<=2;startAt++) {
            for (int i=startAt;i<sticker.length;i++) {
                // 다시 앞으로 돌아와 체크할 수 있으니 그 경우를 제외하도록 visit에 방문 여부 체크
                visit[startAt][i] = true;
                // 그리고 2, 3칸 뒤에 있는 경우에 최댓값 업데이트
                for (int next=2;next<=3;next++) {
                    // 범위 안벗어나도록
                    int nextIdx = (i+next) % sticker.length;
                    // 만약 다음 스티커를 뗐다면 탐색 X
                    if (0 < dp[startAt][(nextIdx + 1)%sticker.length]) continue;
                    // 방문 하지 않은 스티커라면
                    if (!visit[startAt][nextIdx]) {
                        // 최댓값 업데이트
                        dp[startAt][nextIdx] = Math.max(
                            dp[startAt][i] + sticker[nextIdx],
                            dp[startAt][nextIdx]
                        );
                    }
                }
            }   
        }
        
        for (int[] startAt : dp) {
            for (int sum : startAt) answer = Math.max(answer, sum);
        }

        return answer;
    }
}