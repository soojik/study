package DAY05.P1722;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static long[] fact = new long[21];

    public static void main(String[] args) throws IOException, FileNotFoundException {
        System.setIn(new FileInputStream("src/DAY05/P1722/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        fact[0] = 1;
        for (int i = 1; i <= 20; i++) {
            fact[i] = fact[i - 1] * i;
        }

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cmd = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        if (cmd == 1) {
            // k 번째 순열
            long K = Long.parseLong(st.nextToken());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i++) {  // 자릿수
                for (int j = 1; j <= N; j++) { // 실제로 고른 숫자
                    if (visited[j]) {
                        continue;
                    }
                    if (K > fact[N - i - 1]) {
                        K -= fact[N - i - 1];
                    } else {
                        sb.append(j).append(" ");
                        visited[j] = true;
                        break;
                    }
                }
            }
            System.out.println(sb);
        } else if (cmd == 2) {
            // 해당 순열이 몇번째 인지
            long result = 0;
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) { // 자리
                for (int j = 1; j < arr[i]; j++) {
                    if (!visited[j]) {
                        result += fact[N - i - 1];
                    }
                }
                visited[arr[i]] = true;
            }

            System.out.println(result + 1);
        }
    }

}