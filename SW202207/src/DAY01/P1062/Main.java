package DAY01.P1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static String[] words;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        if (k < 5) {
            System.out.println(0);
            return;
        }

        if (k == 26) {
            System.out.println(n);
            return;
        }

        words = new String[n];
        for (int i=0;i<n;i++) words[i] = br.readLine();

        visited = new boolean[26];
        visited['a'-'a'] = true;
        visited['n'-'a'] = true;
        visited['t'-'a'] = true;
        visited['i'-'a'] = true;
        visited['c'-'a'] = true;

        max = 0;

        dfs(0, 0);

        System.out.println(max);
    }

    static void dfs(int node, int index) {
        if (index == k-5) {
            int cnt = 0;
            boolean check;
            for (int i=0;i<n;i++) {
                check = true;
                for (int j=0;j<words[i].length();j++) {
                    if (!visited[words[i].charAt(j) - 'a']) {
                        check = false;
                        break;
                    }
                }
                if (check) cnt++;
            }
            max = Math.max(max, cnt);
        }

        else {
            for (int i=node;i<26;i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(i, index+1);
                    visited[i] = false;
                }
            }
        }
    }
}

