class Solution {
    public int bestClosingTime(String customers) {
        int closeAt = customers.length();

        // 현재 패널티
        int curr_penalty = 0;
        // 최소 패널티
        int min_penalty = Integer.MAX_VALUE;
        for (char c : customers.toCharArray()) if (c == 'N') curr_penalty += 1;
        min_penalty = curr_penalty;
        for (int t=customers.length()-1;t>=0;t--) {
            // 손님 있는 시간에 닫으면 패널티 증가
            if (customers.charAt(t) == 'Y') curr_penalty += 1;
                // 손님 없는 시간에 닫으면
            else {
                // 패널티 감소
                curr_penalty -= 1;
                // 감소한 현재 패널티가 최소 패널티보다 작거나 같다면(같은 패널티이어도 더 이른 시간으로 업데이트)
                if (curr_penalty <= min_penalty) {
                    // 닫는 시간 현재 t로 업데이트
                    closeAt = t;
                    // 최소 패널티 업데이트
                    min_penalty = curr_penalty;
                }
            }
        }

        return closeAt;
    }
}