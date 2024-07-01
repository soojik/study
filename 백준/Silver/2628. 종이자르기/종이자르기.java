import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int cnt = Integer.parseInt(br.readLine());

        int dir, idx;
        List<Integer> h_arr = new ArrayList<>();
        List<Integer> v_arr = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            dir = Integer.parseInt(st.nextToken());
            idx = Integer.parseInt(st.nextToken());

            /*
            0: 가로
            1: 세로
             */
            if (dir == 0) {
                h_arr.add(idx);
                continue;
            }
            v_arr.add(idx);
        }

        h_arr.add(N);
        v_arr.add(M);
        Collections.sort(h_arr);
        Collections.sort(v_arr);

        int h_max = h_arr.get(0);
        for (int i = 1; i < h_arr.size(); i++) {
            h_max = Math.max(h_max, h_arr.get(i) - h_arr.get(i - 1));
        }

        int v_max = v_arr.get(0);
        for (int i = 1; i < v_arr.size(); i++) {
            v_max = Math.max(v_max, v_arr.get(i) - v_arr.get(i - 1));
        }

        System.out.println(h_max * v_max);
    }
}
