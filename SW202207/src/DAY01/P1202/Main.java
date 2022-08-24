package DAY01.P1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int[] bags;
    static Jams[] jams;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());  // 보석
        K = Integer.parseInt(stk.nextToken());  // 가방

        jams = new Jams[N];
        bags = new int[K];

        for (int i=0;i<N;i++) {
            stk = new StringTokenizer(br.readLine());

            jams[i] = new Jams(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
        }

        for (int i=0;i<K;i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 가방 정렬
        // 보석 무게대로 정렬
        Arrays.sort(jams, Comparator.comparingInt(Jams::getWeight));
        Arrays.sort(bags);

        int p = 0; // 보석 포인터
        int cnt = 0;
        PriorityQueue<Jams> pq = new PriorityQueue<>(Comparator.comparingInt(Jams::getPrice).reversed());
        // 가방 순회하며 넣을 수 있는 보석 탐색
        // 해당 가방에 들어갈 수 있는 보석 priorityQueue에 가격 삽입해 가방보다 큰 보석 나오면 cnt에 더해준다
        // 보석 포인터가 마지막에 다다르면 while문 종료

        for (int i=0;i<K;i++) {
            while (p < N && jams[p].weight <= bags[i]) {
                pq.add(jams[p++]);
            }
            if (!pq.isEmpty()) {
                cnt += pq.poll().price;
            }
        }

        System.out.println(cnt);
    }
}

class Jams {
    int weight;
    int price;

    public Jams (int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }
}
