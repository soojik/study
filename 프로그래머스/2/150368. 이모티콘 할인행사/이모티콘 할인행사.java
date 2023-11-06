import java.util.*;

class Solution {
    int emoticons_len; // 이모티콘 수
    PriorityQueue<Result> pq = new PriorityQueue(); // 목표에 가까운대로 할인율 마다 나올 결과를 저장
    
    public int[] solution(int[][] users, int[] emoticons) {
        emoticons_len = emoticons.length;
        
        // 크기가 5인 2차원 리스트로 [할인율/10] 인덱스에 할인한 가격들을 저장
        List<List<Integer>> combi = new ArrayList();
        
        for (int i=0;i<5;i++) combi.add(new ArrayList());
        
        makeCombination(users, emoticons, 0, combi);
        
        Result answer = pq.poll();
        return new int[]{answer.가입자, answer.매출액};
    }
    
    // combi에 할인율에 따라 나올 수 있는 모든 조합을 저장
    public void makeCombination(int[][] users, int[] emoticons, int depth, List<List<Integer>> combi) {
        // 해당 경로에 대한 조합을 완성했으면
        if (depth == emoticons_len) {
            int 가입수 = 0;
            int 구매액 = 0;
            // 사용자 순회하며
            for (int[] user : users) {
                int 할인율 = (user[0] % 10 == 0) ? user[0] / 10 : user[0] / 10 + 1;
                int 상한선 = user[1];
                
                // 비율을 참고해 구매할 이모티콘 가격을 합산
                int 할인이모티콘구입액 = 0;
                for (int i=할인율;i<=4;i++) {
                    for (int price : combi.get(i)) {
                        할인이모티콘구입액 += price;
                    }    
                }
                
                // 그 가격이 상한선 넘으면 이모티콘 플러스 가입
                if (상한선 <= 할인이모티콘구입액) ++가입수;
                // 아니라면 그냥 구입
                else 구매액 += 할인이모티콘구입액;
            }
            
            // 해당 combi 할인 조합에 대한 결과 넣어주기
            pq.add(new Result(가입수, 구매액));
            
            return;
        }
        
        // 조합 만들기
        for (int i=1;i<=4;i++) {
            int afterDiscount = emoticons[depth] / 100 * (10-i) * 10;
            combi.get(i).add(afterDiscount);
            makeCombination(users, emoticons, depth+1, combi);
            combi.get(i).remove(Integer.valueOf(afterDiscount));
        }
    }
}

class Result implements Comparable<Result> {
    int 가입자;
    int 매출액;
    
    public Result (int 가입자, int 매출액) {
        this.가입자 = 가입자;
        this.매출액 = 매출액;
    }
    
    @Override
    public int compareTo(Result r) {
        if (this.가입자 == r.가입자) return r.매출액 - this.매출액;
        return r.가입자 - this.가입자;
    }
    
    @Override
    public String toString() {
        return this.가입자 + " " + this.매출액;
    }
}