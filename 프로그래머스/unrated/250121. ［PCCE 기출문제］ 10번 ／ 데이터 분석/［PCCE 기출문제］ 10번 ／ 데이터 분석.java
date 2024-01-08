import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        HashMap<String, Integer> index_map = new HashMap();
        
        index_map.put("code", 0);
        index_map.put("date", 1);
        index_map.put("maximum", 2);
        index_map.put("remain", 3);
        
    List<int[]> answer_list = Arrays.stream(data).filter((int[] arr) ->
                    arr[index_map.get(ext)] < val_ext)
            .sorted((int[] arr1, int[] arr2) -> arr1[index_map.get(sort_by)] - arr2[index_map.get(sort_by)])
            .collect(Collectors.toList());
        
        int[][] answer = new int[answer_list.size()][4];
        int idx = 0;
        for (int[] a : answer_list) 
            answer[idx++] = a;
        
        return answer;
    }
}