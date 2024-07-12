import java.util.*;

class Solution {
    HashSet<Integer> pokemon_set = new HashSet();    
    public int solution(int[] nums) {
        for (int n : nums) pokemon_set.add(n);
        
        return Math.min(nums.length/2, pokemon_set.size());
    }
}