class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 0};
        
        int len_r = wallpaper.length;
        int len_c = wallpaper[0].length();
        
        for (int i=0;i<len_r;i++) {
            for (int j=0;j<len_c;j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    answer[0] = Math.min(answer[0], i);
                    answer[1] = Math.min(answer[1], j);
                    answer[2] = Math.max(answer[2], i);
                    answer[3] = Math.max(answer[3], j);
                }
            }
        }
        
        // 오른쪽끝점은 각 x,y 에 대해 1을 더해줘야한다.
        ++answer[2];
        ++answer[3];
        
        return answer;
    }
}