class Solution {
    boolean[][] connections;
    boolean[] visit;
    int cnt;
    public int solution(int n, int[][] wires) {
        int answer = n;
        connections = new boolean[n + 1][n + 1];
        
        // boolean[][] connections: {r, c}의 연결 관계를 나타낸다.
        for (int[] wire : wires) {
            connections[wire[0]][wire[1]] = connections[wire[1]][wire[0]] = true;
        }
        
        // wires 순회하며 하나씩 끊어보고 최소 차이값을 찾는다.
        for (int[] wire : wires) {
            connections[wire[0]][wire[1]] = connections[wire[1]][wire[0]] = false;
            visit = new boolean[n + 1];
            int diff = 0;
            for (int i=1;i<=n;i++) {
                if (visit[i]) continue;
                // 방문하지 않은 노드부터 시작
                // 방문여부 체크, 송전탑 개수를 cnt에 센다.
                cnt = 1;
                visit[i] = true;
                dfs(n, i);
                // 탐색 후 완성된 cnt 를 diff 에 더해주고
                diff += cnt;
                // 다음 송전탑 그룹과의 차이값을 구하기위해 -1 을 곱해준다.
                diff *= -1;
            }
            // 차이값의 절댓값과 answer 를 비교해 최솟값으로 업데이트
            answer = Math.min(Math.abs(diff), answer);
            // connection 원복
            connections[wire[0]][wire[1]] = connections[wire[1]][wire[0]] = true;
        }
        
        return answer;
    }
    
    void dfs(int n, int node) {
        
        for (int i=1;i<=n;i++) {
            if (!visit[i] && connections[node][i]) {
                ++cnt;
                visit[i] = true;
                dfs(n, i);
            }
        }
    }
}