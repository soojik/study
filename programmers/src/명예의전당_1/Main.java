package 명예의전당_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})));
        System.out.println(Arrays.toString(s.solution(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000})));
    }

}

class Solution {
    public int[] solution(int k, int[] score) {
        int day = score.length;
        int[] answer = new int[day];

        List<Integer> list = new ArrayList<>();

        for (int i=0;i<day;i++) {
            list.add(score[i]);
            list.sort(Comparator.naturalOrder());

            int size = list.size();
            if (size > k) {
                list.remove(0);
            }

            answer[i] = list.get(0);
        }

        return answer;
    }
}