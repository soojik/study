class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        // 최대 체력
        int MAX_HEALTH = health;
        
        int 시전_시간 = bandage[0];
        int 초당_회복량 = bandage[1];
        int 추가_회복량 = bandage[2];
        
        // 마지막 공격 시각(초)
        int last_attack_second = 0;
        for (int[] a : attacks) {
            // 현재 공격 정보(초, 데미지)
            int curr_s = a[0];
            int curr_d = a[1];
            
            // 이전 공격부터 현재 공격까지 아무 것도 없던 시간
            int 아무것도_없던_시간 = curr_s - last_attack_second - 1;
            
            // 
            health = Math.min(MAX_HEALTH,
                              // 기본 체력에
                              health
                              // 아무것도 없던 시간 동안 회복한 값
                              + 초당_회복량 * 아무것도_없던_시간
                              // 중간에 연속 성공한 횟수(뜬 시간 / 시전 시간)만큼 추가 회복량 곱해서 더해주기
                              + 아무것도_없던_시간 / 시전_시간 * 추가_회복량);
            
            // 공격으로 체력 잃음
            health -= curr_d;
            
            // 만약 0 이하가 됐다면 죽었으니 -1 반환
            if (health <= 0) return -1;
            
            // 마지막 공격 시간 업데이트
            last_attack_second = curr_s;
        }
        
        return health;
    }
}