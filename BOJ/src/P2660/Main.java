package P2660;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/*
각 정점에서 가장 멀리 있는 정점의 거리를 구하는 문제이다.
그런 다음 가장 짧은 거리로만 이루어져 있는 사람을 회장 후보로 선출하면 된다.
모든 정점에서 다른 모든 정점으로의 거리를 구할 때는 플로이드 와샬 알고리즘이 간편하다.

플로이드 와샬 시간복잡도는 O(n^3)이기 때문에 해당 문제와 같이 크기가 적당한 문제들에게만 적용이 가능하다.
 */

public class Main {
    static int N;
    static int a, b;
    static int[][] map;
    static int max, min = 100;
    static int[] score;
    static List<Integer> result;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2660/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    map[i][j] = 100;
                }
            }
        }

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (a == -1) {
                break;
            }

            map[a][b] = 1;
            map[b][a] = 1;
        }

        for (int m = 1; m <= N; m++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    if (map[s][m] + map[m][e] < map[s][e]) {
                        map[s][e] = map[s][m] + map[m][e];
                    }
                }
            }
        }

        score = new int[N+1];
        for (int i = 1; i <= N; i++) {
            max = 0;
            for (int j = 1; j <= N; j++) {
                max = Math.max(max, map[i][j]);
            }
            score[i] = max;
            min = Math.min(min, max);
        }

        result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (score[i] == min) {
                result.add(i);
            }
        }

        Collections.sort(result);
        sb.append(min).append(" ").append(result.size()).append("\n");
        for (int score : result) {
            sb.append(score).append(" ");
        }

        System.out.println(sb);
    }
}
