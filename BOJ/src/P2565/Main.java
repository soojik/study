package P2565;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Wire> wires = new ArrayList<>();;
    static int[] end_arr;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/BOJ/P2565/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        StringTokenizer st;
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            wires.add(new Wire(start, end));
        }

        // 시작점 오름차순으로 정렬
        wires.sort(Comparator.comparingInt(Wire::getStart));
        
        end_arr = new int[N];

        for (int i=0;i<N;i++) {
            end_arr[i] = wires.get(i).getEnd();
        }

        dp = new int[N];
        dp[0] = 1;

        for (int i=1;i<N;i++) {
            dp[i] = 1;

            for (int j=0;j<i;j++) {
                if (end_arr[j] < end_arr[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max_length = 0;
        for (int i=0;i<N;i++) {
            max_length = Math.max(max_length, dp[i]);
        }

        System.out.println(N - max_length);
    }
}

class Wire {
    int start, end;

    public Wire(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}