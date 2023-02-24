package 카드뭉치;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
        System.out.println(s.solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
    }

}

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int len1 = cards1.length;
        int len2 = cards2.length;
        int len_g = goal.length;

        int idx1 = 0, idx2 = 0;
        for (int i=0;i<len_g;i++) {
            if (idx1 < len1 && goal[i].equals(cards1[idx1])) {
                idx1++;
            }
            else if (idx2 < len2 && goal[i].equals(cards2[idx2])) {
                idx2++;
            }
            else {
                return "No";
            }
        }

        return "Yes";

    }
}