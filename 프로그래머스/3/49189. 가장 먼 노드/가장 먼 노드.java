import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 1로부터 i번째 노드까지 나오는 모든 거리
        List<Integer> distanceFrom1 = new ArrayList();
        
        List<List<Integer>> connections = new ArrayList();
        
        for (int i=0;i<=n;i++) connections.add(new ArrayList());
        
        for (int[] e : edge) {
            connections.get(e[0]).add(e[1]);
            connections.get(e[1]).add(e[0]);
        }
        
        boolean[] visit = new boolean[n+1];
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{1, 0});
        visit[1] = true;
        
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            
            int node = tmp[0];
            int cnt = tmp[1];
            
            // node까지 거리
            distanceFrom1.add(cnt);
            
            // 연결되어있고 아직 방문 안한 노드에 대해
            for (int next : connections.get(node)) {
                if (connections.get(node).contains(next) && !visit[next]) {
                    // 방문 체크 해주고
                    visit[next] = true;
                    // 계속 탐색
                    q.add(new int[]{next, cnt+1});
                }
            }
        }
        
        // 나올 수 있는 거리 중 가장 큰 값
        int max = Collections.max(distanceFrom1);
        
        // 이 몇번 나왔는지 반환
        return Collections.frequency(distanceFrom1, max);
        
    }
    
}