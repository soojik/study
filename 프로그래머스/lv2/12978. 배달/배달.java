import java.util.HashSet;

class Solution {
    // {i, j} 사이의 가중치 정보를 담고있는 배열
    int[][] connections;
    // i 노드에 대한 방문 여부
    boolean[] visit;
    // 방문할 수 있는 마을 번호 담고있는 set
    HashSet<Integer> set = new HashSet();
    public int solution(int N, int[][] road, int K) {

        connections = new int[N + 1][N + 1];
        
        // 가중치는 최솟값 기준으로 업데이트해준다.
        int r2;
        for (int[] r : road) {
            r2 = r[2];
            connections[r[0]][r[1]] = (connections[r[0]][r[1]] == 0) ? r2 : Math.min(r2, connections[r[0]][r[1]]);
            connections[r[1]][r[0]] = connections[r[0]][r[1]];
        }
        
        // 1번 마을은 무조건 갈 수 있으므로 true 로 체크하고, dfs 탐색 진행한다.
        visit = new boolean[N + 1];
        visit[1] = true;
        dfs(1, 0, K, N);

        // 갈 수 있는 마을의 수를 반환한다.
        return set.size();
    }
    
    void dfs (int node, int sum, int k, int n) {
        // 이제까지 온 길에 걸린 시간(sum)이 기준 k를 넘는다면 탐색 중단
        if (sum > k) return;
        
        // 그 외에는 갈 수 있는 마을로, set에 추가해준다.
        if (!set.contains(node)) {
            set.add(node);
        }
        
        if (sum == k) return;
        
        // 2번 마을부터 n번 마을까지 순회하며 
        for (int i=2;i<=n;i++) {
            // 방문 여부 체크하고 갈 수 있는 마을이라면
            if (!visit[i] && connections[node][i] != 0) {
                // 방문 체크 후,
                visit[i] = true;
                // 다음 탐색 진행
                dfs(i, sum+connections[node][i], k, n);
                visit[i] = false;
            }
        }
    }
}