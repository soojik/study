package P2346;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Deque<Balloon> deque;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/src/P2346/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Deque의 구현체는 LinkedList, ArrayDeque가 있는데
        // LinkedList로 구현하면 이중 연결리스트라 메모리 사용량에서 초과나서 ArrayDeque로 구현
        deque = new ArrayDeque<>();

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            deque.addLast(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        int[] answer = new int[N];
        int idx_answer = 0;

        while (!deque.isEmpty()) {
            Balloon curr = deque.pollFirst();

            answer[idx_answer++] = curr.index + 1;

            if (idx_answer == N) {
                StringBuilder sb = new StringBuilder();
                for (int i : answer) {
                    sb.append(i).append(" ");
                }
                System.out.println(sb);
                return;
            }

            int jump = curr.note;

            if (jump > 0) {
                while (--jump > 0) {
                    deque.addLast(deque.pollFirst());
                }
            }
            else {
                while (jump++ < 0) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }
    }
}

class Balloon {
    int index;
    int note;

    public Balloon(int index, int note) {
        this.index = index;
        this.note = note;
    }
}