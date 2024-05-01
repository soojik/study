import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s = br.readLine();
      
      int[] alpha = new int[26];
      for (char c : s.toCharArray()) ++alpha[c-'a'];
      
      StringBuffer sb = new StringBuffer();
      for (int cnt : alpha) sb.append(cnt).append(" ");
      
      System.out.println(sb);
  }
}
