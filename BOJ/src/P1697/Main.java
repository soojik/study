package P1697;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
! 주의 !
valid 검사를 먼저 해줘야함
아니면 visit 배열에서 인덱스 오류 난다요
 */

public class Main {
    static int MAX = 100001;
    static int N, K;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1697/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new boolean[MAX];

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(N, 0));
        visit[N] = true;

        while (!q.isEmpty()) {
            Info curr = q.poll();

            if (curr.point == K) {
                System.out.println(curr.cnt);
                break;
            } else {
                if (valid(curr.point + 1) && !visit[curr.point + 1]) {
                    q.add(new Info(curr.point + 1, curr.cnt + 1));
                    visit[curr.point + 1] = true;
                }
                if (valid(curr.point - 1) && !visit[curr.point - 1]) {
                    q.add(new Info(curr.point - 1, curr.cnt + 1));
                    visit[curr.point - 1] = true;
                }
                if (valid(curr.point * 2) && !visit[curr.point * 2]) {
                    q.add(new Info(curr.point * 2, curr.cnt + 1));
                    visit[curr.point * 2] = true;
                }
            }
        }
    }

    public static boolean valid(int point) {
        return 0 <= point && point < MAX;
    }
}

class Info {
    int point;
    int cnt;

    public Info(int point, int cnt) {
        this.point = point;
        this.cnt = cnt;
    }
}