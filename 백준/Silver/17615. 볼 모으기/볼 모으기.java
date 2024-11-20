import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String str = br.readLine();

    char[] arr = new char[N];
    int idx = 0;
    int blue = 0;
    for (char c : str.toCharArray()) {
      arr[idx++] = c;
      if (c == 'B') ++blue;
    }
    int red = N - blue;

    int p = 0;
    int cnt = 0;
    int answer = Math.min(blue, red);
    while (p <= N - 1) {
      if (arr[p++] != arr[0]) break;
      ++cnt;
    }

    if (arr[0] == 'R')
      answer = Math.min(answer, red - cnt);
    else
      answer = Math.min(answer, blue - cnt);

    p = N - 1;
    cnt = 0;
    while (p >= 0) {
      if (arr[p--] != arr[N - 1]) break;
      else ++cnt;
    }

    if (arr[N - 1] == 'R')
      answer = Math.min(answer, red - cnt);
    else
      answer = Math.min(answer, blue - cnt);

    System.out.println(answer);
  }
}
