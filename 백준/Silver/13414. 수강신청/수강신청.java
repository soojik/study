import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> waitList = new LinkedHashSet<>();

        for (int i = 0; i < L; i++) {
            String num = br.readLine();
            if (waitList.contains(num)) {
                waitList.remove(num);
            }
            waitList.add(num);
        }

        int idx = 0;
        for (String num : waitList) {
            if (idx++ == K) return;
            System.out.println(num);
        }
    }
}
