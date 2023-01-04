package P2217;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] ropes;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/src/P2217/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ropes = new int[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);

        int answer = 0;
        // 오름차순 정렬된 ropes 배열 순회하며 그 중 최솟값(ropes[i])과 i부터 N-1까지의 로프 갯수(N-i-1+1 == N-i)
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, ropes[i] * (N - i));
        }

        System.out.println(answer);
    }
}
