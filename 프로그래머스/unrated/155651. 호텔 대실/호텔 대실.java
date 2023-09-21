import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int solution(String[][] book_time) {
        // 필요한 방 갯수
        int answer = 0;
        
        int len = book_time.length;
        int[][] schedule = new int[len][2];
        
        // schedule 은 {시작 시간(분 기준), 종료 시간(분 기준)} 으로 주어진 데이터를 변환한 배열
        String[] time_arr;
        for (int i=0;i<len;i++) {
            time_arr = book_time[i][0].split(":");
            schedule[i][0] = Integer.parseInt(time_arr[0]) * 60 + Integer.parseInt(time_arr[1]);
            time_arr = book_time[i][1].split(":");
            schedule[i][1] = Integer.parseInt(time_arr[0]) * 60 + Integer.parseInt(time_arr[1]);
        }
        
        // 시작시간 기준으로 정렬
        Arrays.sort(schedule, (o1, o2) -> o1[0] - o2[0]);
        
        // stack(방) 을 저장할 list
        List<Stack> list = new ArrayList<>();
        // 스케쥴을 순회하며
        loop: for (int[] s : schedule) {
            // answer(현재 방 개수)만큼 반복하며(방 하나씩 방문) 종료 + 10(청소시간) 보다 시작 시간이 큰 곳을 찾으면 바로 저장한다.
            for (int i=0;i<answer;i++) {
                if ((int) list.get(i).peek() + 10 <= s[0]) {
                    list.get(i).push(s[1]);
                    continue loop;
                }
            }
            // 못찾았으면 새로운 방 하나 더해준다.
            list.add(new Stack<Integer>());
            ++answer;
            list.get(answer - 1).push(s[1]);
            continue;
        }
        
        return answer;
    }
}