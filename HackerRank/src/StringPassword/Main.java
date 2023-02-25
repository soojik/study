package StringPassword;

import java.io.*;

class Result {

  /*
   * Complete the 'minimumNumber' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. STRING password
   */

  public static int minimumNumber(int n, String password) {
    // Return the minimum number of characters to make the password strong

    int level = 4;

    for (int i=0;i<n;i++) {
      if (Character.isDigit(password.charAt(i))) {
        level--;
        break;
      }
    }

    for (int i=0;i<n;i++) {
      if (Character.isLowerCase(password.charAt(i))) {
        level--;
        break;
      }
    }

    for (int i=0;i<n;i++) {
      if (Character.isUpperCase(password.charAt(i))) {
        level--;
        break;
      }
    }

    for (int i=0;i<n;i++) {
      if (!Character.isLetterOrDigit(password.charAt(i))) {
        level--;
        break;
      }
    }

    return Math.max(level, 6 - n);

  }

}

public class Main {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("HackerRank/src/StringPassword/input.txt"));
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    String password = bufferedReader.readLine();

    int answer = Result.minimumNumber(n, password);

    bufferedWriter.write(String.valueOf(answer));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
