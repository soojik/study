import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = stoi(br.readLine());
      
    int[] nums = new int[N];
      
      for (int i=0;i<N;i++) nums[i] = stoi(br.readLine());
      
      Arrays.sort(nums);
      
      for (int n : nums) System.out.println(n);
  }
}
