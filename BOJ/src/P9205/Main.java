package P9205;

/*
상근이네 집, 편의점, 펜타포트 락 페스티벌 좌표
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;
    static int N;
    static List<Info> CVS;
    static Info destination;
    static boolean[] visit;
    static String answer;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P9205/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            Queue<Info> queue = new LinkedList<>();

            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            queue.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

            CVS = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                CVS.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            st = new StringTokenizer(br.readLine());
            destination = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            answer = "sad";

            visit = new boolean[N];
            while (!queue.isEmpty()) {
                Info curr = queue.poll();

                if ((Math.abs(curr.x - destination.x) + Math.abs(curr.y - destination.y)) <= 1000) {
                    answer = "happy";
                    break;
                }

                for (int i = 0; i < N; i++) {
                    if (!visit[i]) {
                        Info nC = CVS.get(i);
                        if ((Math.abs(curr.x - nC.x) + Math.abs(curr.y - nC.y)) <= 1000) {
                            visit[i] = true;
                            queue.add(nC);
                        }
                    }
                }
            }

            System.out.println(answer);
        }
    }
}

class Info {
    int x;
    int y;

    public Info(int x, int y) {
        this.x = x;
        this.y = y;
    }
}