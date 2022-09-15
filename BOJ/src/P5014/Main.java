package P5014;

/*
스타트링크는 총 F층으로 이루어진 고층 건물에 사무실이 있고, 스타트링크가 있는 곳의 위치는 G층이다.
강호가 지금 있는 곳은 S층이고, 이제 엘리베이터를 타고 G층으로 이동하려고 한다.
use the stairs
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P5014/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visit = new boolean[F+1];

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(S, 0));
        visit[S] = true;

        while (!q.isEmpty()) {
            Info curr = q.poll();

            if (curr.point == G) {
                System.out.println(curr.cnt);
                return;
            } else {
                if (valid(curr.point + U) && !visit[curr.point + U]) {
                    q.add(new Info(curr.point + U, curr.cnt + 1));
                    visit[curr.point + U] = true;
                }
                if (valid(curr.point - D) && !visit[curr.point - D]) {
                    q.add(new Info(curr.point - D, curr.cnt + 1));
                    visit[curr.point - D] = true;
                }
            }
        }

        System.out.println("use the stairs");
    }

    public static boolean valid(int point) {
        return 1 <= point && point <= F;
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