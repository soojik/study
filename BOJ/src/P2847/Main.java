package P2847;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P2847/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] points = new int [N];
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }


        int answer = 0;

        // 배열은 뒤에서 부터
        for (int i=N-1;i>=1;i--) {
            // 현재 레벨과 바로 앞 레벨의 점수 차를 가져온다.
            int diff = points[i] - points[i - 1];

            // 점수 차가 음수이면 앞 레벨 점수가 더 크다는 것을 의미하므로 현재 레벨 점수보다 작게 설정해줘야한다.
            if (diff <= 0) {
                // 최소로 감소해야하는 수를 구해야하므로 (현재 레벨 점수-1) 로 다시 값 설정
                // diff가 두 레벨 점수의 차이며 음수값이므로 전 레벨 점수에 [diff(점수 차) - 1]을 더해준다.
                points[i - 1] += diff - 1;
                // 정답 출력할 answer에는 얼마나 감소시켰는지 더해야하기 때문에 [diff(점수 차 - 1]을 빼준다.
                answer -= diff - 1;
            }
        }

        System.out.println(answer);
    }
}
