package P1062;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static String[] words;
    static boolean[] visit;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1062/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().replaceAll("[antic]", "");
        }

        visit = new boolean[26];
        visit['a' - 'a'] = true;
        visit['n' - 'a'] = true;
        visit['t' - 'a'] = true;
        visit['i' - 'a'] = true;
        visit['c' - 'a'] = true;

        if (K < 5) {
            System.out.println(0);
            return;
        }
        if (K == 26) {
            System.out.println(N);
            return;
        }

        dfs(0, 0);

        System.out.println(max);
    }

    public static void dfs(int alpha, int depth) {
        int cnt = 0;

        if (depth == K - 5) {
            for (int i = 0; i < N; i++) {
                boolean FalseAnswer = false;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!visit[words[i].charAt(j) - 'a']) {
                        FalseAnswer = true;
                        break;
                    }
                }
                if (!FalseAnswer) cnt++;
            }
            max = Math.max(max, cnt);
            return;
        }

        for (int i = alpha; i < 26; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i, depth + 1);
                visit[i] = false;
            }
        }
    }
}
