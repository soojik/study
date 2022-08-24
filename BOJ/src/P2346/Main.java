package P2346;

import java.io.*;
import java.util.*;

public class Main {
    static Deque<Item> q;
    static int N;
    public static class Item {
        int index;
        int next;

        public Item(int index, int next) {
            this.index = index;
            this.next = next;
        }
    }
    public static void main(String[] args) throws IOException, FileNotFoundException {
        System.setIn(new FileInputStream("src/P2346/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());

        q = new ArrayDeque<>();
         for (int i=0;i<N;i++) {
             q.add(new Item(i, Integer.parseInt(stk.nextToken())));
         }

         StringBuffer sb = new StringBuffer("");
         Item item = new Item(0, 0);
         // q에 하나 남아있을때까지
        while (q.size() > 1) {
            // 만약 item.next <= 0 -> 앞에서 뽑아옴
            if (item.next >= 0) {
                item = q.pollFirst();
            }
            // else 뒤에서 뽑아옴
            else {
                item = q.pollLast();
            }
            sb.append(item.index+1).append(" ");
            // while 문으로 다음 item까지 차례 돌림
            for (int i = 1; i < Math.abs(item.next); i++) {
                if (item.next > 0) {
                    q.addLast(q.pollFirst());
                }
                else {
                    q.addFirst(q.pollLast());
                }
            }
            // 만약 next >= 0 이면 앞에서
        }
        sb.append(q.pollFirst().index+1);
        System.out.println(sb);
    }
}
