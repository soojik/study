package P2457;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/src/P2457/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];

        StringTokenizer st;
        int startM, startD, endM, endD;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            startM = Integer.parseInt(st.nextToken());
            startD = Integer.parseInt(st.nextToken());
            endM = Integer.parseInt(st.nextToken());
            endD = Integer.parseInt(st.nextToken());

            flowers[i] = new Flower(startM * 100 + startD, endM * 100 + endD);
        }

        Arrays.sort(flowers);

        /*
        for (Flower f : flowers) {
            System.out.println(f);
        }
         */

        int start_date = 301;
        int end_date = start_date;
        int cnt = 0;

        for (Flower flower : flowers) {
            // 현재 flower의 시작 날이 start_date보다 작거나 같다면
            if (flower.start <= start_date) {
                // flower의 마지막 날짜가 end_date보다 크다면 end_date 갱신
                end_date = Math.max(end_date, flower.end);
            }

            // 현재 Flower의 시작 날이 start_date보다 크다면
            else {
                // 만약 end_date가 12월 1일보다 크거나 같다면 정원 완성이라는 의미로, break
                if (1201 <= start_date) {
                    break;
                }

                // 이전의 end_date로 start_date 갱신
                start_date = end_date;

                // 한 종류의 꽃을 지정했으므로 cnt+1
                cnt++;
                if (flower.start <= start_date) {
                    end_date = Math.max(end_date, flower.end);
                }
            }

        }

        // 모든 꽃을 순회하고 시작 날짜가 12월 1일보다 작으면
        if (start_date <= 1130) {
            // 현재 start_date보다 작은 값의 시작 날짜를 갖는 꽃의 탐색 중이던 것을 고려해 cnt에 1을 더해준다.
            // 탐색을 완료하고 for문을 나왔다면 start_date 값이 1201을 넘을 것이다.
            cnt++;
            // 현재 end_date에 저장되어있는 마지막 날짜를 가져온다.
            start_date = end_date;

        }

        // 갱신한 start_date(모든 꽃을 순회하고 나온 꽃이 피어있는 마지막 날짜인 end_date)가 12월 1일이 넘지 못하면
        if (start_date <= 1130) {
            // 0을 출력
            System.out.println(0);
        } else {
            // 넘는다면 cnt를 출력한다.
            System.out.println(cnt);
        }
    }
}

class Flower implements Comparable<Flower> {
    int start, end;

    public Flower(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Flower o) {
        if (this.start == o.start) {
            return o.end - this.end;
        } else {
            return this.start - o.start;
        }
    }

    @Override
    public String toString() {
        return "Flower{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}