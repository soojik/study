package DAY01.P11279;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static long[] list;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        Heap heap = new Heap();

        for (int i=0;i<N;i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                bw.write(Integer.toString(heap.remove()));
                bw.newLine();
            } else {
                heap.insert(input);
            }
        }

        bw.flush();
        bw.close();
    }

}

class Heap {
    List<Integer> list;

    public Heap() {
        list = new ArrayList<>();
        list.add(0);
    }

    public void insert(int node) {
        // leaf 마지막에 삽입
        list.add(node);
        // 부모와 비교 후 조건에 맞지 않으면 Swap
        // 조건이 만족되거나 root까지 반복
        int cur = list.size() - 1;
        int parent = cur / 2;
        while (true) {
            // 조건 부합하면 탈출 -> 현재 루트노드(부모 노드가 0)
            if (parent == 0 || list.get(parent) >= list.get(cur)) {
                break;
            }

            int temp = list.get(parent);
            list.set(parent, list.get(cur));
            list.set(cur, temp);

            cur = parent;
            parent = cur / 2;
        }
    }

    public int remove() {
        // 처음 아무것도 없으면 0 반환
        if (list.size() == 1) {
            return 0;
        }
        // root에 leaf 마지막 데이터 가져옴
        int top = list.get(1);
        list.set(1, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        // 자식과 비교 후 조건이 맞지 않으면 swap
        // 조건이 만족되거나 leaf까지 반복 -> 자식 유무 확인
        int curPos = 1;
        while (true) {
            int left = 2 * curPos;
            int right = 2 * curPos + 1;

            // 왼쪽 자식 확인
            if (left >= list.size()) {
                break;
            }

            int maxVal = list.get(left);
            int maxPos = left;

            // 오른쪽 자식 확인
            if (right < list.size() && maxVal < list.get(right)) {
                maxVal = list.get(right);
                maxPos = right;
            }
            // swap
            if (list.get(curPos) < maxVal) {
                int tmp = list.get(curPos);
                list.set(curPos, maxVal);
                list.set(maxPos, tmp);
                curPos = maxPos;
            }
        }
        return top;
    }

}