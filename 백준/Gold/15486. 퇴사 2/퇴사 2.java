import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    Appointment[] appointments = new Appointment[N];
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      appointments[i] = new Appointment(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    int[] pays = new int[N + 1];
    for (int i = 0; i < N; i++) {
      if (i != 0) pays[i] = Math.max(pays[i], pays[i - 1]);
      if (i + appointments[i].time > N) continue;
      pays[i + appointments[i].time] = Math.max(pays[i + appointments[i].time], appointments[i].pay + pays[i]);
    }

    int answer = 0;
    for (int pay : pays) {
      answer = Math.max(answer, pay);
    }

    System.out.println(answer);
  }
}

class Appointment {
  int time;
  int pay;

  public Appointment(int time, int pay) {
    this.time = time;
    this.pay = pay;
  }
}