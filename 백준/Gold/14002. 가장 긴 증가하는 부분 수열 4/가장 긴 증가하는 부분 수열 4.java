import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  static int stoi(String s) {return Integer.parseInt(s);}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = stoi(br.readLine());
    int[] nums = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = stoi(st.nextToken());
    }

    int[] dp = new int[N];
    int[] parent = new int[N];

    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        if (nums[i] < nums[j] && dp[j] <= dp[i]) {
          dp[j] = dp[i] + 1;
          parent[j] = i;
        }
      }
    }

    int max = 0;
    int index = 0;
    for (int i = 0; i < N; i++) {
      if (max < dp[i]) {
        max = dp[i];
        index = i;
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(max + 1).append("\n");

    Stack<Integer> stack = new Stack<>();
    stack.add(index);
    while (max-- > 0) {
      stack.add(parent[index]);
      index = parent[index];
    }

    while (!stack.isEmpty()) {
      sb.append(nums[stack.pop()]).append(" ");
    }

    System.out.println(sb);
  }
}
