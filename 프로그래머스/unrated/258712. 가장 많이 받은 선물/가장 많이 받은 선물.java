import java.util.HashMap;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int N = friends.length;
        
        HashMap<String, Integer> friend_index = new HashMap();
        
        // {i, j} -> i가 j한테 선물 준 횟수
        int[][] gift_cnt = new int[N][N];
        
        // // 주고받은 선물 {이름 : {이름 : 선물 준 }}
        // HashMap<String, HashMap<String, Integer>> gift_cnt = new HashMap();
        // 선물 지수 {인덱스 : 선물 지수}
        HashMap<Integer, Integer> gift_score = new HashMap();
        
        for (int i=0;i<N;i++) {
            friend_index.put(friends[i], i);
            // gift_cnt.put(friend, new HashMap());
            gift_score.put(i, 0);
        }
        
        // 주고 받은 선물, 선물 지수 기록
        for (String gift : gifts) {
            String[] split_tmp = gift.split(" ");
            
            int from_index = friend_index.get(split_tmp[0]);
            int to_index = friend_index.get(split_tmp[1]);
            
            // from 이 to 에게 준 선물 +1
            ++gift_cnt[from_index][to_index];
            
            /* 선물 지수
            준 사람은 +1
            받은 사람은 -1
            */
            gift_score.put(from_index, gift_score.get(from_index) + 1);
            gift_score.put(to_index, gift_score.get(to_index) - 1);
        }
        
        for (int k : gift_score.keySet()) System.out.println(k + " " + gift_score.get(k));
        
        int[] predicts = new int[N];
        for (int i=0;i<N-1;i++) {
            for (int j=i+1;j<N;j++) {
                // 선물을 더 많이 받은 사람이 상대방에게 선물을 한 번 더 받는다.
                // i가 받은 선물보다 준 선물이 많다면
                if (gift_cnt[j][i] < gift_cnt[i][j]) {
                    ++predicts[i];
                }
                // j가 받은 선물보다 준 선물이 많다면
                else if (gift_cnt[j][i] > gift_cnt[i][j]) {
                    ++predicts[j];
                }
                
                // 주고받은 수가 같다면 선물 지수가 더 큰 사람이 한 번 더 받는다.
                if (gift_cnt[i][j] == gift_cnt[j][i]) {
                    // 선물 지수도 같다면 다음 달에는 선물을 주고받지 않는다.
                    if (gift_score.get(i) == gift_score.get(j)) continue;
                    int higher_score = (gift_score.get(i) < gift_score.get(j)) ? j : i;
                    
                    ++predicts[higher_score];
                }
            }
        }
        
        for (int i=0;i<N;i++) answer = Math.max(answer,predicts[i]);
        
        return answer;
    }
}