import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
  static int N, M, K;
  static boolean[][] map;
  // 빈 영역 개수
  static int answer = 0;
  // 영역 넓이 카운트할 변수
  static int cnt = 0;
  // 영역 넓이 저장할 List 변수
  static List<Integer> list = new ArrayList<>();

  static int[] dr = {0, -1, 0, 1};
  static int[] dc = {-1, 0, 1, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new boolean[N][M];

    /*
    map 에서 방문하지 못할, 직사각형 영역을 체크해준다.
    칠해진 영역의 왼쪽 상단 지점에 표시해준다.
    */
    int start_r, start_c, end_r, end_c;
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());

      start_c = Integer.parseInt(st.nextToken());
      start_r = Integer.parseInt(st.nextToken());
      end_c = Integer.parseInt(st.nextToken());
      end_r = Integer.parseInt(st.nextToken());

      for (int j = start_r; j < end_r; j++) {
        for (int k = start_c; k < end_c; k++) {
          map[j][k] = true;
        }
      }
    }

    // 모든 영역을 순회하며 색칠안된 영역 찾으면 깊이 우선 탐색 진행
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!map[i][j]) {
          // 영역 넓이 구하기위해 0으로 초기화
          cnt = 0;
          // 현재 위치 방문 완료 표시
          map[i][j] = true;
          // 빈 영역 1 증가
          ++answer;
          // 현재 위치부터 탐색 진행
          dfs(i, j);
          // 리스트에 빈 영역 넓이 넣어준다.
          list.add(cnt);
        }
      }
    }

    // 넓이들을 저장한 리스트 정렬 후, 하나씩 꺼내서 sb 에 더해준다.
    StringBuilder sb = new StringBuilder();

    Collections.sort(list);
    for (int a : list) {
      sb.append(a).append(" ");
    }

    // 빈 영역 개수와 넓이 출력
    System.out.println(answer);
    System.out.println(sb);
  }

  static void dfs(int r, int c) {
    ++cnt;
    int nr, nc;
    for (int i = 0; i < 4; i++) {
      nr = r + dr[i];
      nc = c + dc[i];

      if (0 <= nr && nr < N && 0 <= nc && nc < M) {
        if (!map[nr][nc]) {
          map[nr][nc] = true;
          dfs(nr, nc);
        }
      }
    }
  }
}
