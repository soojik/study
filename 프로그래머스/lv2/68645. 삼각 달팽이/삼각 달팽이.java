class Solution {
    // {아래, 오른쪽, 좌상향} 세 방향으로 이동하며 2차원 배열을 직각 삼각형 모양으로 채워준다.
    // 위 방향대로 이동하며 차례로 n, n - 1, n - 2 만큼 배열을 채워야한다.
    int[] dr = {1, 0, -1};
    int[] dc = {0, 1, -1};
    public int[] solution(int n) {
        // arr: 값을 채울 2차원 배열
        int[][] arr = new int[n + 1][n + 1];
        
        // answer: 채워진 수를 차례로 따로 빼서 출력할 1차원 배열
        // 크기는 n + (n-1) + ... + 1
        int len = 0;
        for (int i=1;i<=n;i++) len += i;
        
        int[] answer = new int[len];
        
        // num: 1부터 차례로 배열을 채운다.
        int num = 1;
        // 시작점 {0, 0}
        // 실제로 1이 들어갈 곳은 {1, 0} 이다.
        int r = 0, c = 0;
        // 삼각형을 채울 때 n부터 1씩 줄여가며 칸을 채운다.
        for (int i=n;i>0;i--) {
            // 이동 방향 설정
            int addR = dr[(n - i) % 3];
            int addC = dc[(n - i) % 3];
            // addR, addC 로 이동하며 i 만큼 칸 채우기
            for (int j=0;j<i;j++) {
                r += addR;
                c += addC;
                arr[r][c] = num++;
            }
        }
        
        // answer 배열 채우는데, 0이 아닌 채워진 곳만 뽑아낸다.
        int idx = 0;
        for (int i=0;i<(n+1) * (n+1);i++) {
            if (arr[i/(n+1)][i%(n+1)] == 0) continue;
            answer[idx++] = arr[i/(n+1)][i%(n+1)];
        }
        
        return answer;
    }
}