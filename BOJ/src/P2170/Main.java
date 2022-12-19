package P2170;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/src/P2170/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N은 주어진 선 긋기 횟수
        int N = Integer.parseInt(br.readLine());
        Line[] lines = new Line[N];

        StringTokenizer st;
        // lines 배열에 주어진 선 영역 가져온다.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i] = new Line(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        // 시작점, 그리고 끝점 기준으로 오름차순 정렬
        Arrays.sort(lines);

        // 처음엔 제일 처음 선, 기준선을 그어준다.
        long start = lines[0].s;
        long end = lines[0].e;

        long answer = 0;

        // 다음에 그린 선들을 순회하며
        for (int i = 1; i < N; i++) {
            Line line = lines[i];

            // 현재 선의 시작점, 끝점을 각 s, e가 참조하게 하고
            long s = line.s;
            long e = line.e;

            // 현재 선의 시작점 s가 이전에 그려진 기준선의 끝점 end 보다 크다면
            // 오름차순 정렬된 이 배열에서 이 뒤의 선들은 시작점이 모두 end보다 크므로 이제 전의 기준선 길이는 정리해도 된다.
            if (end < s) {
                // 이전의 선 길이 end - start는 answer에 더해주고
                answer += end - start;
                // 현재 선을 새로운 기준선으로 설정한다.
                start = s;
                end = e;
            }
            // 현재 선의 시작점 s이 기준선의 끝점 end보다 작을 때는 두 선의 일정 부분이 겹친다는 뜻
            else {
                // 이 상황에서 현재 선의 끝점이 e가 클때는 기준선의 end만 e로 갱신해준다.
                if (end < e) {
                    end = e;
                }
            }
        }

        // 순회 종료 후 마지막 남은 기준선 길이를 answer에 더해준다.
        answer += end - start;

        System.out.println(answer);
    }
}

class Line implements Comparable<Line> {
    long s, e;

    public Line(long s, long e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Line o) {
        if (this.s == o.s) {
            return (int) (this.e - o.e);
        } else {
            return (int) (this.s - o.s);
        }

    }
}