import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int p_len = photo.length;
        int n_len = name.length;
        
        int[] answer = new int[p_len];
        
        // name이랑 yearning 값 매핑
        HashMap<String, Integer> map = new HashMap();
        for (int i=0;i<n_len;i++) {
            map.put(name[i], yearning[i]);
        }
        
        // 각 배열 순회하며
        for (int i=0;i<p_len;i++) {
            // 해당 사진 속 사람들
            for (String n : photo[i]) {
                // 매핑된 값이 있다면 값 찾아서 해당 사진의 그리움 점수에 더해주기
                answer[i] += map.getOrDefault(n, 0);
            }
        }
        
        return answer;
    }
}