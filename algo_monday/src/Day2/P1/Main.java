package Day2.P1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int test, n;
    static double[] students;
    static double sum, avg;
    static int result;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Day2/P1/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            n = Integer.parseInt(br.readLine());

            sum = 0;
            students = new double[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                sum += students[i] = Integer.parseInt(st.nextToken());
            }

            avg = sum / n;

            result = 0;
            for (int i = 0; i < n; i++) {
                if (students[i] >= avg)
                    result++;
            }

            sb.append(result).append("/").append(n).append("\n");
        }

        System.out.println(sb);
    }
}
