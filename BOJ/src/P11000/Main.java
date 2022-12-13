package P11000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P11000/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[N];

        StringTokenizer st;
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(lectures, (o1, o2) -> {
            if (o1.S == o2.S) {
                return o1.T - o2.T;
            } else {
                return o1.S - o2.S;
            }
        });

        PriorityQueue<Integer> pq_T = new PriorityQueue<>();
        pq_T.add(lectures[0].T);

        for (int i=1;i<N;i++) {
            if (pq_T.peek() <= lectures[i].S) {
                pq_T.poll();
            }
            pq_T.offer(lectures[i].T);
        }

        System.out.println(pq_T.size());
    }

}

class Lecture implements Comparable<Lecture>{
    int S, T;

    public Lecture(int S, int T) {
        this.S = S;
        this.T = T;
    }


    @Override
    public int compareTo(Lecture o) {
        if (o.T == this.T) {
            return o.S - this.S;
        } else {
            return o.T - this.T;
        }
    }

    public int getS() {
        return S;
    }

    public int getT() {
        return T;
    }
}
