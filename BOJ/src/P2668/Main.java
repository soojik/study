package P2668;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visit;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2668/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        visit = new boolean[N+1];
        list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            visit[i] = true;
            dfs(i, i);
            visit[i] = false;
        }

        System.out.println(list.size());

        Collections.sort(list);
        for (int n : list) {
            System.out.println(n);
        }
    }

    public static void dfs(int start, int target) {
        if (!visit[arr[start]]) {
            visit[arr[start]] = true;
            dfs(arr[start], target);
            visit[arr[start]] = false;
        }

        if (arr[start] == target) {
            list.add(target);
        }
    }
}
