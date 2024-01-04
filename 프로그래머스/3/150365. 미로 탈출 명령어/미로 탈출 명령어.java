import java.util.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder answer = new StringBuilder();
        
        int distance = Math.abs(x - r) + Math.abs(y - c);
        
        // k보다 S-E 사이 거리가 크다면
        if (k < distance) return "impossible";
        
        // S-E 사이가 작지만 갈 수 없다면
        if (Math.abs(distance - k) % 2 == 1) return "impossible";
        
        // S부터 E까지 어느 방향으로 얼만큼 이동해야하는지
        int down = Math.max(r - x, 0);
        int up = Math.max(x - r, 0);
        int left = Math.max(y - c, 0);
        int right = Math.max(c - y, 0);
        // 도착지에 도착하고도 이동 횟수가 2배수로 남았다면 du, ud, lr, rl로 제자리 걸음을 할 수 있다.
        int pair = Math.abs(distance - k) / 2;
        
        // k만큼 반복
        for (int i=0;i<k;i++) {
            // 만약 down할 곳이 있고, down 해야할 횟수가 남았거나 제자리걸음 수가 남았다면
            if ((0 < down || 0 < pair) && x < n) {
                // d 추가
                answer.append('d');
                // 만약 down 횟수가 남아 이동한 것이라면 down -= 1
                if (0 < down) --down;
                // 제자리 걸음이라면
                else {
                    --pair;
                    // up도 한번 해야하니까 up += 1
                    ++up;
                }
                ++x;
            }
            else if ((0 < left || 0 < pair) && 1 < y) {
                answer.append('l');
                if (0 < left) --left;
                else {
                    --pair;
                    ++right;
                }
                --y;
            }
            else if ((0 < right || 0 < pair) && y < m) {
                answer.append('r');
                if (0 < right) --right;
                else {
                    --pair;
                    ++left;
                }
                ++y;
            }
            else if ((0 < up || 0 < pair) && 1 < x) {
                answer.append('u');
                if (0 < up) --up;
                else {
                    --pair;
                    ++down;
                }
                --x;
            }
        }
        
        
        return answer.toString();
    }
}