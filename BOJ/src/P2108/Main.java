package P2108;

/*
산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이
 */

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static int[] cnt = new int[10000];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2108/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i] = Integer.parseInt(br.readLine());
            cnt[nums[i]+4000]++;
        }

        // 1
        System.out.println((int) Math.round((double) sum / N));

        // 2
        Arrays.sort(nums);
        System.out.println(nums[nums.length/2]);

        // 3
        int min = nums[0];
        int max = nums[nums.length - 1];
        int max_cnt = 0;

        for (int i = min + 4000; i <= max + 4000; i++) {
            max_cnt = Math.max(max_cnt, cnt[i]);
        }

        for (int i = min + 4000; i <= max + 4000; i++) {
            if (cnt[i] == max_cnt) {
                list.add(i - 4000);
            }
        }

        Collections.sort(list);

        if (list.size() >= 2) {
            System.out.println(list.get(1));
        } else {
            System.out.println(list.get(0));
        }

        // 4
        System.out.println(nums[nums.length-1] - nums[0]);
    }
}
