import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 최댓값과최솟값 {

  public static void main(String[] args) {
    System.out.println(solution("1 2 3 4"));
    System.out.println(solution("-1 -2 -3 -4"));
    System.out.println(solution("-1 -1"));
  }

  public static String solution(String s) {
    String answer = "";

    List<Integer> nums = Arrays.stream(s.split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    nums.sort(Comparator.naturalOrder());

    StringBuilder sb = new StringBuilder();
    sb.append(nums.get(0)).append(" ").append(nums.get(nums.size()-1));

    return sb.toString();
  }
}
