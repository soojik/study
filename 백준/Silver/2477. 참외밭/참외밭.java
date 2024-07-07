import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
가장 긴 가로 길이 옆에 있는 두 세로 길이의 차가 빼야할 직사각형의 세로 길이이다.
반대도 동일하다.
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    int[][] points = new int[6][2];
    for (int i = 0; i < 6; i++) {
      st = new StringTokenizer(br.readLine());
      points[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
    }

    int max_w = 0, max_h = 0; // 가장 긴 가로, 세로 길이
    int w_idx = 0, h_idx = 0; // 최대 길이를 가진 가로, 세로 인덱스 저장
    for (int i = 0; i < 6; i++) {
      // 최대 가로 길이
      if (points[i][0] <= 2 && max_w < points[i][1]) {
        max_w = points[i][1]; // 길이 업데이트
        w_idx = i; // 가장 긴 가로길이 인덱스
      }
      // 최대 세로 길이
      if (2 < points[i][0] && max_h < points[i][1]) {
        max_h = points[i][1]; // 길이 업데이트
        h_idx = i; // 가장 긴 세로길이 인덱스
      }
    }
    
    // 빼야할 직사각형의 높이는 가장 긴 가로길이 옆 세로 길이의 차
    int min_h = Math.abs(points[(w_idx + 5) % 6][1] - points[(w_idx + 1) % 6][1]);
    // 빼야할 직사각형의 넓이는 가장 긴 세로길이 옆 가로 길이의 차
    int min_w = Math.abs(points[(h_idx + 5) % 6][1] - points[(h_idx + 1) % 6][1]);
    System.out.println((max_w * max_h - min_w * min_h) * N);
  }
}
