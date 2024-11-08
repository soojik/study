import java.util.*;

class Solution {
    List<List<int[]>> graph = new ArrayList();
    // s -> i -> a + s -> i -> b
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        for (int i=0;i<=n;i++) graph.add(new ArrayList<int[]>());
        
        for (int[] f : fares) {
            graph.get(f[0]).add(new int[]{f[1], f[2]});
            graph.get(f[1]).add(new int[]{f[0], f[2]});
        }
        
        int[] dist_s = 최단거리(n, s);
        int[] dist_a = 최단거리(n, a);
        int[] dist_b = 최단거리(n, b);
        
        for (int i=1;i<=n;i++) {
            answer = Math.min(answer, dist_s[i] + dist_a[i] + dist_b[i]);
        }
        
        return answer;
    }
    
    int[] 최단거리(int n, int start) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new int[]{start, 0});
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            for (int[] next : graph.get(curr[0])) {
                if (dist[curr[0]] + next[1] < dist[next[0]]) {
                    dist[next[0]] = dist[curr[0]] + next[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }
        
        return dist;
    }
}