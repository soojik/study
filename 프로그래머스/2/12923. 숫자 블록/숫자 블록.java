class Solution {
    public int[] solution(long begin, long end) {
        int len = (int) (end - begin) + 1;
        int[] answer = new int[len];
        
        for (int i=0;i<len;i++) {
            long num = begin + i;
            if (num == 1) {
                answer[0] = 0;
                continue;
            }
            double sqrt = Math.sqrt(num);
            for (long l=2;l<=sqrt;l++) {
                if (num % l == 0) {
                    if (10000000 < num / l) {
                        answer[i] = (int) l;
                        continue;
                    }
                    answer[i] = (int) (num / l);
                    break;
                }
            }
            if (answer[i] == 0) answer[i] = 1;
        }
        
        return answer;
    }
}