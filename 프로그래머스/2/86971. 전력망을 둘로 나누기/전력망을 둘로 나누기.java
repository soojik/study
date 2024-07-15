import java.util.*;

class Solution {
    boolean[][] con;
    public int solution(int n, int[][] wires) {
        int answer = 101;
        
        con = new boolean[n + 1][n + 1];
        for (int[] w : wires) {
            int s = w[0], e = w[1];
            con[s][e] = con[e][s] = true;
        }
        
        for (int[] w : wires) {
            int s = w[0], e = w[1];
            con[s][e] = con[e][s] = false;
            int area1 = 끊기(s, n, wires);
            int area2 = 끊기(e, n, wires);
            con[s][e] = con[e][s] = true;
            answer = Math.min(Math.abs(area1 - area2), answer);
        }
        
        return answer;
    }
    
    public int 끊기(int start, int n, int[][] wires) {
        int cnt = 0;
        boolean[] visited = new boolean[n + 1];
        
        Queue<Integer> q = new LinkedList();
        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            ++cnt;
            
            for (int i = 1;i <= n;i++) {
                if (visited[i] || !con[curr][i]) continue;
                visited[i] = true;
                q.add(i);
            }
        }
        
        return cnt;
    }
}