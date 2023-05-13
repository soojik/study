import java.util.HashMap;
        import java.util.Collections;
        import java.util.List;
        import java.util.ArrayList;
public class 귤고르기 {

  public static void main(String[] args) {
    System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    System.out.println(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
  }

  public static int solution(int k, int[] tangerine) {
    HashMap<Integer, Integer> cnt = new HashMap<>();

    for (int t : tangerine) {
      if (cnt.containsKey(t)) {
        cnt.put(t, cnt.get(t)+1);
      }
      else {
        cnt.put(t, 1);
      }
    }

    List<Integer> cnt_desc = new ArrayList(cnt.values());
    Collections.sort(cnt_desc, Collections.reverseOrder());

    int len = cnt_desc.size();
    int i;
    for (i=0;i<len;i++) {
      if (k <= 0) break;
      k -= cnt_desc.get(i);
    }

    return i;
  }
}