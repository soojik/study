import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /*
    플레이어가 입장을 신청하였을 때 매칭이 가능한 방이 없다면 새로운 방을 생성하고 입장시킨다. 이떄 해당 방에는 처음 입장한 플레이어의 레벨을 기준으로 -10부터 +10까지 입장 가능하다.
    입장 가능한 방이 있다면 입장시킨 후 방의 정원이 모두 찰 때까지 대기시킨다.
    이때 입장이 가능한 방이 여러 개라면 먼저 생성된 방에 입장한다.
    방의 정원이 모두 차면 게임을 시작시킨다.
     */

    int p, m;
    StringTokenizer st = new StringTokenizer(br.readLine());
    p = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    // {기준 레벨, 인원}
    List<List<Player>> rooms = new ArrayList<>();
    while (p-- > 0) {
      st = new StringTokenizer(br.readLine());
      int l = Integer.parseInt(st.nextToken());
      String n = st.nextToken();

      boolean find = false;
      for (List<Player> r : rooms) {
        // 들어갈 수 있다면 입장
        if (r.get(0).getLevel() - 10 <= l && l <= r.get(0).getLevel() + 10 && r.size() < m) {
          // 인원 + 1
          r.add(new Player(l, n));
          find = true;
          break;
        }
      }

      if (find) continue;

      List<Player> new_room = new ArrayList<>();
      new_room.add(new Player(l, n));
      rooms.add(new_room);
    }

    StringBuffer sb = new StringBuffer();
    for (List<Player> r : rooms) {
      sb.append(r.size() == m ? "Started!" : "Waiting!").append("\n");
      Collections.sort(r);
      for (Player player : r) {
        sb.append(player.getLevel()).append(" ").append(player.getName()).append("\n");
      }
    }

    System.out.println(sb);
  }
}

class Player implements Comparable<Player> {
  int level;
  String name;

  public int getLevel() {
    return level;
  }

  public String getName() {
    return name;
  }

  public Player(int level, String name) {
    this.level = level;
    this.name = name;
  }

  @Override
  public int compareTo(Player p) {
    return this.name.compareTo(p.name);
  }
}