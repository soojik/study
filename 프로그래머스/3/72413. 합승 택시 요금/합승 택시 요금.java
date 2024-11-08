import java.util.*;

class Solution {
    List<List<int[]>> graph = new ArrayList();
    // s -> i -> a + s -> i -> b
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        int[][] dist = new int[n+1][n+1];
        for (int i=0;i<=n;i++) {
            Arrays.fill(dist[i], 1000001);
            dist[i][i] = 0;
        }
        
        for (int[] f : fares) {
            dist[f[0]][f[1]] = f[2];
            dist[f[1]][f[0]] = f[2];
        }
        
        for (int k=1;k<=n;k++) {
            for (int i=1;i<=n;i++) {
                for (int j=1;j<=n;j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        for (int i=1;i<=n;i++) {
            answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
        }
        
        return answer;
    }
}