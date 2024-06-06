import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int startAt = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

    int endAt = (startAt + Integer.parseInt(br.readLine())) % (24 * 60);

    System.out.println(endAt / 60 + " " + endAt % 60);
  }
}
