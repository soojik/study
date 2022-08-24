package DAY03.P2243;

import java.io.*;

public class Main {
    static int[] tree;
    public static void main(String[] args) throws IOException, FileNotFoundException {
        System.setIn(new FileInputStream("src/DAY03/P2243/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    }

    static int Query(int left, int right, int node, int count) {
        // leaf 노드 도달하면 번호 반환
        if (left == right) {
            return left;
        } else {
            int mid = (left + right) / 2;
            if (tree[node*2] >= count) {
                return Query(left, mid, node*2, count);
            } else {
                return Query(mid+1, right, node*2+1, count-=tree[node*2]);
            }
        }
    }

//    static int update(int left, int right, int node, int diff) {
//
//    }
}
