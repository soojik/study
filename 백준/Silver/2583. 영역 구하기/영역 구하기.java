import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int M, N, K;
  static boolean[][] map;
  static boolean[][] visited;
  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, 1, 0, -1};
  static List<Integer> area = new ArrayList<>();
  static int stoi (String s) {
    return Integer.parseInt(s);}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    M = stoi(st.nextToken());
    N = stoi(st.nextToken());
    K = stoi(st.nextToken());

    map = new boolean[M][N];
    visited = new boolean[M][N];

    // 왼쪽밑[c, r], 오른쪽위 [c, r]
    int[] start, end;
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      start = new int[]{stoi(st.nextToken()), stoi(st.nextToken())};
      end = new int[]{stoi(st.nextToken()), stoi(st.nextToken())};
      check(start, end);
    }

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j] && !map[i][j]) {
          bfs(i, j);
        }
      }
    }

    area.sort((i1, i2) -> i1 - i2);
    sb.append(area.size()).append("\n");
    for (int i : area) {
      sb.append(i).append(" ");
    }
    System.out.println(sb);
  }

  static void bfs (int r, int c) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{r, c});
    visited[r][c] = true;

    int max = 0;
    while(!q.isEmpty()) {
      int[] curr = q.poll();
      ++max;

      int nr, nc;
      for (int i = 0; i < 4; i++) {
        nr = curr[0] + dr[i];
        nc = curr[1] + dc[i];

        if (0 <= nr && nr < M && 0 <= nc && nc < N && !visited[nr][nc] && !map[nr][nc]) {
          visited[nr][nc] = true;
          q.add(new int[]{nr, nc});
        }
      }
    }

    area.add(max);
  }

  static void check(int[] start, int[] end) {
    for (int i = start[1]; i < end[1]; i++) {
      for (int j = start[0]; j < end[0]; j++) {
        map[i][j] = true;
      }
    }
  }
}
