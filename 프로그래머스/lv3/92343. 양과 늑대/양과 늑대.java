import java.util.List;
import java.util.ArrayList;

class Solution {
    // 노드 개수
    int len;
    // {r,c}가 부모-자식 노드 관계인지
    boolean[][] tree;
    int answer = 0;
    public int solution(int[] info, int[][] edges) {
        
        len = info.length;
        tree = new boolean[len][len];
        
        // edges 순회하며 부모-자식 노드 체크
        int edges_r = edges.length;
        for (int[] edge : edges) {
            tree[edge[0]][edge[1]] = true;
        }
        
        /* 0번째 노드부터 시작
        방문배열 초기화하고
        0번째는 무조건 양이니까 양 1, 늑대 0로 초기화
        */
        dfs(0, new ArrayList(), 1, 0, info);
        
        return answer;
    }
    
    /*
    int node: 현재 노드
    List<Integer> nextNodes: 다음에 방문할 노드들 (예시2를 보면 1 먼저 탐색 후 2 탐색한 다음, 다시 1쪽으로 가야하기때문에 부모 노드에서 다음에 가야할 노드들을 한번 기억해준다.)
    int sheep: 양 수
    int wolf: 늑대 수
    int[] info: 주어진 info 배열
    */
    public void dfs (int node, List<Integer> nextNodes, int sheep, int wolf, int[] info) {
        // 늑대가 양보다 같거나 많아진다면
        if (sheep <= wolf) {
            // 해당 경로 탐색 종료
            return;
        }
        
        // 최대로 가질 수 있는 양 업데이트
        answer = Math.max(answer, sheep);
        
        // 이전 노드들 방문하며 저장해왔던 방문 배열 복사
        List<Integer> nexts = new ArrayList(nextNodes);
        // 현재 노드에서 다시 방문할 수 있는 자식 노드 추가
        for (int i=0;i<len;i++) {
            if (tree[node][i]) {
                nexts.add(i);
            }
        }
        
        // 현재 노드는 이미 방문했으니 삭제
        nexts.remove(Integer.valueOf(node));
        
        // 노드 방문
        for (int next : nexts) {
            // 다음이 0이면 양에 1 더해주고 재귀호출
            if (info[next] == 0) {
                dfs(next, nexts, sheep+1, wolf, info);   
            }
            // 다음이 1이면 늑대에 1 더해주고 재귀호출
            else {
                dfs(next, nexts, sheep, wolf+1, info);
            }
        }
    }
}