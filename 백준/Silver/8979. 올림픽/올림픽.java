import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        금메달 수가 더 많은 나라
        금메달 수가 같으면, 은메달 수가 더 많은 나라
        금, 은메달 수가 모두 같으면, 동메달 수가 더 많은 나라
         */

        int N, K;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<int[]> country = new ArrayList<>();

        int idx, g, s, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            idx = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            country.add(new int[]{idx, g, s, b});
        }

        country.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    if (o1[2] == o2[2]) {
                        return o2[3] - o1[3];
                    }
                    return o2[2] - o1[2];
                }
                return o2[1] - o1[1];
            }
        });

        int ans = 1;
        int term = 1;
        for (int i = 0; i < N; i++) {
            if (i != 0) {
                if (isSame(country.get(i), country.get(i - 1))) {
                    ++term;
                }
                else {
                    ans += term;
                    term = 1;
                }
            }
            if (country.get(i)[0] == K) {
                System.out.println(ans);
                return;
            }
        }
        System.out.println(ans);
    }

    static boolean isSame(int[] c1, int[] c2) {
        for (int i = 1; i <= 3; i++) {
            if (c1[i] != c2[i]) return false;
        }
        return true;
    }
}