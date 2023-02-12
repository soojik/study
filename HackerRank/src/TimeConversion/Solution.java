package TimeConversion;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'timeConversion' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  public static String timeConversion(String s) {
    // Write your code here
    int len = s.length();
    boolean isAM = s.substring(len - 2, len).equals("AM");

    List<Integer> time = Stream.of(s.substring(0, len-2).split(":"))
            .map(Integer::parseInt)
            .collect(toList());

    if (isAM) {
      return String.format("%02d:%02d:%02d",
              (time.get(0) >= 12) ? time.get(0) - 12 : time.get(0),
              time.get(1),
              time.get(2));
    } else {
      return String.format("%02d:%02d:%02d",
              (time.get(0) < 12) ? time.get(0) + 12 : time.get(0),
              time.get(1),
              time.get(2));
    }
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    String result = Result.timeConversion(s);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
