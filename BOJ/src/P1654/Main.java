package P1654;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long target;
    static long[] wires;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/src/P1654/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        target = Long.parseLong(st.nextToken());

        wires = new long[N];

        long longest_wire = 0;
        for (int i = 0; i < N; i++) {
            longest_wire = Math.max(longest_wire, wires[i] = Long.parseLong(br.readLine()));
        }

        System.out.println(BinarySearch(1, longest_wire));

    }

    static long BinarySearch(long low, long high) {
        long mid = 0L;
        long count;

        while (low <= high) {

            mid = (low + high) / 2;

            count = 0;
            for (int i = 0; i < N; i++) {
                count += wires[i] / mid;
            }

            // target보다 작다면, count를 늘려야하므로 길이를 범위를 줄인다.
            // high = mid
            if (count < target) {
                high = mid - 1;
            }

            // target보다 크거나 같다면, 자를 길이를 최대한으로 늘려야하므로 범위를 키운다.
            // low = mid + 1
            else {
                low = mid + 1;
            }
        }

        return (high+low)/2;
    }
}
