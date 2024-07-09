import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.MemoryType;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str1 = br.readLine();
    String str2 = br.readLine();
    int len1 = str1.length();
    int len2 = str2.length();

    int[][] dp = new int[len1 + 1][len2 + 1];
    String ans = new String();
    String[][] s_arr = new String[len1 + 1][len2 + 1];

    int max = 0;
    for (int i = 1; i <= len1; i++) {
      for (int j = 1; j <= len2; j++) {
        if (dp[i - 1][j] > dp[i][j - 1]) {
          dp[i][j] = dp[i - 1][j];
          s_arr[i][j] = s_arr[i - 1][j];
        }
        else {
          dp[i][j] = dp[i][j - 1];
          s_arr[i][j] = s_arr[i][j - 1];
        }

        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          if (dp[i][j] < dp[i - 1][j - 1] + 1) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
            s_arr[i][j] = s_arr[i - 1][j - 1] == null ? str1.charAt(i - 1) + "" : s_arr[i - 1][j - 1] + str1.charAt(i - 1);
          }
        }
        if (dp[i][j] > max) {
          max = dp[i][j];
          ans = s_arr[i][j];
        }
      }
    }

    System.out.println(max);
    if (max == 0) return;

    System.out.println(ans);
  }
}
