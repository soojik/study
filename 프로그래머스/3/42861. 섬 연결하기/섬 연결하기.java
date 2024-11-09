import java.util.*;

class Solution {
    List<List<int[]>> graph = new ArrayList();
    int answer = Integer.MAX_VALUE;
    public int solution(int n, int[][] costs) {
        
        for (int i=0;i<=n;i++) graph.add(new ArrayList<int[]>());
        
        for (int[] c : costs) {
            graph.get(c[0]).add(new int[]{c[1], c[2]});
            graph.get(c[1]).add(new int[]{c[0], c[2]});
        }
        
        return 최단거리(n);
    }
    
    int 최단거리(int n) {
        Queue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        boolean[] visited = new boolean[n];
        pq.add(new int[]{0, 0});
        
        int cnt = 0;
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            if (visited[curr[0]]) continue;
            
            visited[curr[0]] = true;
            ++cnt;
            sum += curr[1];
            
            for (int[] next : graph.get(curr[0])) {
                if (visited[next[0]]) continue;
                pq.add(next);
            }
        }
        
        return sum;
    }
}