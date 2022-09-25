package P1181;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static int N;
    static List<String> list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1181/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (!list.contains(input)) {
                list.add(input);
            }
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
