package P2805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] woods;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/src/P2805/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        woods = new int[N];

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            max = Math.max(max, woods[i] = Integer.parseInt(st.nextToken()));
        }

        int min = 1;
        int mid = 0;

        while (min < max) {

            // 중간점이자 자르려는 길이
            mid = (min + max) / 2;

            // 톱으로 잘랐을 때 남은 나무길이의 합
            long tmp = 0;
            for (int i = 0; i < N; i++) {
                tmp += (woods[i] <= mid) ? 0 : woods[i] - mid;
            }

            // 원하는 나무 길이를 얻을 수 있는 '최대' 설정값을 찾아야 하므로
            // 이분탐색 중 탐색하는 값을 초과하는 데이터의 첫 인덱스를 찾는 upper bound를 이용
            // 그러므로 결과값에는 -1을 해줘야 한다.
            if (tmp >= M) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        // upper bound로 첫 초과값의 인덱스를 구한 것이므로 1을 빼줘야 한다.
        System.out.println(min - 1);

    }
}
