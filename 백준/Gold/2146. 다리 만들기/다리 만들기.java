import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[][] land;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<int[]> q = new LinkedList<>();
    static int tmp = Integer.MAX_VALUE;// 섬별로 결과 비교
    public static void dfs(int x, int y, int id) {
        visited[x][y] = true;
        land[x][y] = id;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && land[nx][ny] == 1) {
                dfs(nx, ny, id);
            }
        }
    }

    public static void bfs(int id) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(land[i][j] == id) {
                    q.offer(new int[] {i,j, id, 0});
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];
            int islandId = t[2];
            int depth = t[3];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    if(land[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx, ny, islandId, depth + 1});
                    }

                    // 다른 섬을 방문했다면 거리 출력
                    if(land[nx][ny] > islandId) {
                        tmp = Math.min(tmp, depth);
                    }
                }


            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        land = new int[n][n];

        // 섬 생성
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 섬에 아이디를 부여하자! (dfs)
        visited = new boolean[n][n];
        int id = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && land[i][j] == 1) {
                    dfs(i, j, id);
                    id++;
                }
            }
        }

        // 이제 섬아이디 별로 섬 간의 거리를 알아보자!
        for(int i = 1; i <= id; i++) {
            visited = new boolean[n][n];
            bfs(i);
        }

        System.out.println(tmp);

    }
}