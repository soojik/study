import java.util.Set;
import java.util.HashSet;

class Solution {
    // String 으로 주어진 수를 int 배열로 변환
    int[] nums;
    // 방문 여부 판별할 배열
    boolean[] visit;
    // 배열 길이
    int len;
    // 찾은 소수를 담을 HashSet
    Set<Integer> answer = new HashSet();
    public int solution(String numbers) {
        len = numbers.length();
        nums = new int[len];
        
        for (int i=0;i<len;i++) nums[i] = numbers.charAt(i) - '0';
        
        visit = new boolean[len];
        
        // 배열 순회하며 완전탐색 진행
        for (int i=0;i<len;i++) {
            visit[i] = true;
            dfs(i, 0, 1);
            visit[i] = false;
        }
        
        return answer.size();
    }
    
    /*
    index: 다음으로 더할 숫자의 인덱스
    num: 현재까지 더해서 완성된 숫자
    depth: 지나온 숫자 개수
    */
    void dfs(int index, int num, int depth) {
        // 현재 숫자를 더한 값을 newNum 이라는 이름으로 저장
        int newNum = num * 10 + nums[index];
        // 소수라면 answer 에 넣어준다.
        if (isPrime(newNum)) answer.add(newNum);
        // 모든 수를 탐색했다면 탐색 종료
        if (depth == len) return;
        
        // 배열 숫자 중 아직 방문하지 않은 곳이 있다면 탐색 진행
        for (int i=0;i<len;i++) {
            if (!visit[i]) {
                // 다음 숫자 방문 체크
                visit[i] = true;
                dfs(i, newNum, depth+1);
                // 방문 체크 취소
                visit[i] = false;
            }
        }
    }
    
    // n으로 들어온 수가 소수인지 판별하는 메서드
    boolean isPrime(int n) {
        
        // 2보다 작으면 소수가 아니다.
        if (n < 2) return false;
        
        int last = (int) Math.sqrt(n);
        for (int i=2;i<=last;i++) {
            // 나누어 떨어지는 수가 있다면 소수가 아니다.
            if (n % i == 0) return false;
        }
        
        // 앞서 소수판별이 무사히 끝나면 소수가 맞다.
        return true;
    }
}