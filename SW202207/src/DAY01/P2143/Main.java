package DAY01.P2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int size1, size2;
    static int[] subnet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(stk.nextToken());

        size1 = Integer.parseInt(br.readLine());
        int[] arr1 = new int[size1];

        stk = new StringTokenizer(br.readLine());
        for (int i=0;i<size1;i++) {
            arr1[i] = Integer.parseInt(stk.nextToken());
        }

        size2 = Integer.parseInt(br.readLine());
        int[] arr2 = new int[size2];

        stk = new StringTokenizer(br.readLine());
        for (int i=0;i<size2;i++) {
            arr2[i] = Integer.parseInt(stk.nextToken());
        }

        List<Integer> sub1 = new ArrayList<>();
        List<Integer> sub2 = new ArrayList<>();
//        int[] sub2 = new int[size2 * size2];

        for (int i=0;i<size1;i++) {
            int tmp = 0;
            for (int j=i;j<size1;j++) {
                tmp += arr1[j];
                sub1.add(tmp);
            }
        }
        Collections.sort(sub1);

        for (int i=0;i<size2;i++) {
            int tmp = 0;
            for (int j=i;j<size2;j++) {
                tmp += arr2[j];
                sub2.add(tmp);
            }
        }
        sub2.sort(Collections.reverseOrder());

        int p1 = 0, p2 = 0;
        long answer = 0;

        while(true) {
            long cur1 = sub1.get(p1);
            long target = num - cur1;
            // currentB == target -> subA, subB 같은 수 개수 체크 -> 답구하기
            if (sub2.get(p2) == target) {
                long count1 = 0;
                long count2 = 0;
                while (p1 < sub1.size() && sub1.get(p1) == cur1) { // 시작할 때 자기자신 카운트
                    count1++;
                    p1++;
                }
                while (p2 < sub2.size() && sub2.get(p2) == target) { // 시작할 때 자기자신 카운트
                    count2++;
                    p2++;
                }
                answer += count1 * count2;
            }
            // currentB > target -> p2++
            else if (sub2.get(p2) > target) {
                p2++;
            }
            // currentB < target -> p1++
            else {
                p1++;
            }

            // 탈출 조건 ; p1||p2 범위를 벗어나게 되면
            if (p1 == sub1.size() || p2 == sub2.size()) {
                break;
            }
        }
        System.out.println(answer);
    }

}
