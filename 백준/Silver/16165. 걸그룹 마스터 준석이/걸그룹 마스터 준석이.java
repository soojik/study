import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, List<String>> group_member = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String group = br.readLine();
            group_member.put(group, new ArrayList<>());

            int member_cnt = Integer.parseInt(br.readLine());

            for (int j = 0; j < member_cnt; j++) {
                group_member.get(group).add(br.readLine());
            }

            Collections.sort(group_member.get(group));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String find_str = br.readLine();
            int quiz = Integer.parseInt(br.readLine());

            /* 0일 경우 팀의 이름이 주어지며, 1일 경우 멤버의 이름 */
            if (quiz == 0) {
                for (String member : group_member.get(find_str)) {
                    sb.append(member).append("\n");
                }
            }
            else if (quiz == 1) {
                for (String group : group_member.keySet()) {
                    if (group_member.get(group).contains(find_str)) {
                        sb.append(group).append("\n");
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
