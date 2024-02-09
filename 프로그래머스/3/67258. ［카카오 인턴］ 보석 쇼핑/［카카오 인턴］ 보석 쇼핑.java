import java.util.*;

class Solution {
    HashSet<String> allTypeOfGems = new HashSet();
    HashMap<String, Integer> gemsCnt = new HashMap();
    public int[] solution(String[] gems) {
        // 모든 구간을 잡도록 초기화
        int[] answer = {0, gems.length-1};
        
        // 투포인터
        int p1 = 0;
        int p2 = 0;
        gemsCnt.put(gems[p1], 1);
        
        // 보석 종류 갯수를 세기 위해
        for (String gem : gems) allTypeOfGems.add(gem);
        
        // p2가 배열 끝까지 갈 때
        while (p2 < gems.length) {
            // 만약 지금 모든 종류의 보석을 가지고
            if (gemsCnt.size() == allTypeOfGems.size()) {
                // 현재 구간(p1 ~ p2) 길이가 (answer[0] ~ answer[1]) 정답 길이보다 짧다면
                if ((p2 - p1) < (answer[1] - answer[0])) {
                    // answer 업데이트
                    answer = new int[]{p1, p2};
                }
                // 만약 길이가 같으면서 시작점(p1)이 현재 정답보다 작다면 answer 업데이트
                // 모든 종류의 보석을 가졌다면 거쳐왔던 보석을 하나씩 없애면서 다시 짧은 구간 탐색
                gemsCnt.put(gems[p1], gemsCnt.get(gems[p1]) - 1);
                if (gemsCnt.get(gems[p1]) == 0) gemsCnt.remove(gems[p1]);
                ++p1;
            }
            // 아직 모든 종류의 보석을 가지지 못했다면 뒤 포인터 증가시키며 탐색 진행
            else {
                ++p2;
                if (p2 == gems.length) break;
                gemsCnt.put(gems[p2], gemsCnt.getOrDefault(gems[p2], 0) + 1);
            }
        }
        
        // 진열대 번호는 인덱스와 달리 1부터 세니까 1씩 더해준다.
        return new int[]{answer[0]+1, answer[1]+1};
    }
}