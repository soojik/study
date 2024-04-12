import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        int N = 0;
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        HashSet<String> whoisincompany = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            String name = arr[0];
            String cmd = arr[1];

            if (cmd.equals("enter")) {
                whoisincompany.add(name);
                continue;
            }
            whoisincompany.remove(name);
        }

        List<String> ans = new ArrayList<>(whoisincompany);
        ans.sort(Collections.reverseOrder());
        for (String name : ans) System.out.println(name);
    }
}
