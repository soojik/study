package P1700;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/src/P1700/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] taps = new int[N];
        int[] use_list = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            use_list[i] = Integer.parseInt(st.nextToken());
        }

        int k = -1;
        int curr_need = 0;
        int change_cnt = 0;
        while(++k < K) {
            boolean using = false;
            boolean empty_tap = false;
            // 현재 필요한 용품 번호
            curr_need = use_list[k];

            // 이미 꽂혀있을 경우
            for (int i = 0; i < N; i++) {
                if (taps[i] == curr_need) {
                    using = true;
                    break;
                }
            }

            if (using) continue;

            // 빈칸 있다면 꽂기
            for (int i = 0; i < N; i++) {
                if (taps[i] == 0) {
                    taps[i] = curr_need;
                    empty_tap = true;
                    break;
                }
            }

            if (empty_tap) continue;

            // 자리가 없어서 뺄 자리 찾아야하는 경우
            // 가장 늦게 다가올 차례
            int last_need = -1;
            // 뺄 멀티탭 자리
            int index = -1;
            // taps 배열 순회
            for (int i = 0; i < N; i++) {
                // 현재 위치 k로부터 떨어진 거리 계산
                int distance = 0;
                // 현재 필요한 용품 뒤에 위치한 배열 순회
                for (int j = k + 1; j < K; j++) {

                    // 뒤에 나온 배열 중 이미 꽂혀있다면 break
                    if (use_list[j] == taps[i]) {
                        break;
                    }
                    // 없다면 distance 1 증가
                    distance++;
                }
                // distance가 last_need보다 크다면
                // distance가 이제까진 가장 먼 곳이므로 이를 last_need에,
                // index에는 현재 자리 갱신
                if (distance > last_need) {
                    last_need = distance;
                    index = i;
                }
            }

            taps[index] = curr_need;
            change_cnt++;
        }

        System.out.println(change_cnt);

    }
}
