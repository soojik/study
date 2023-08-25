import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        /*
        carsInTime: 차량 번호 - 입차 시간
        carsStayTime: 차량 번호 - 누적 시간
        */
        Map<String, Integer> carsInTime = new HashMap();
        Map<String, Integer> carsStayTime = new HashMap();
        
        int hh, mm, time, inTime, outTime, stayTime, pay;
        String car_num;
        
        for (String record : records) {
            String[] str_arr = record.split(" ");
            car_num = str_arr[1];
            
            // 입차라면
            if (str_arr[2].equals("IN")) {
                // 시간 계산해서
                hh = Integer.parseInt(str_arr[0].split(":")[0]);
                mm = Integer.parseInt(str_arr[0].split(":")[1]);

                time = getMinutes(hh, mm);

                // carsInTime에 기록
                carsInTime.put(car_num, time);
            }
            
            // 출차라면
            else {
                // 이전에 입차기록 가져온 후 삭제
                inTime = carsInTime.get(car_num);
                carsInTime.remove(car_num);
                
                // 출차 시간(outTime) 계산해서 carsStayTime, 이전 누적시간에 outTime - inTime 을 더해준다.
                hh = Integer.parseInt(str_arr[0].split(":")[0]);
                mm = Integer.parseInt(str_arr[0].split(":")[1]);
                
                outTime = getMinutes(hh, mm);
                
                carsStayTime.put(car_num, carsStayTime.getOrDefault(car_num, 0) + outTime - inTime);
                
            }
        }
        
        // 남아있는 입차기록들은 출차가 23:59라고 판단하므로 미리 출차시간을 midnightMM 으로 저장
        int midnightMM = 24 * 60 - 1;
        for (String num : carsInTime.keySet()) {
            inTime = carsInTime.get(num);
            
            carsStayTime.put(num, carsStayTime.getOrDefault(num, 0) + midnightMM - inTime);
        }
        
        // 답 배열은 누적기록과 같은 길이로,
        int[] answer = new int[carsStayTime.size()];
        int idx = 0;
        
        // 차량 번호만 뽑아(carsStayTime.keySet()), 정렬 후에
        List<String> carNums = new ArrayList(carsStayTime.keySet());
        Collections.sort(carNums);
        
        // 차량 번호 오름차순으로 순회
        for (String num : carNums) {
            pay = 0;
            
            // 기본요금인 경우
            if (carsStayTime.get(num) <= fees[0]) {
                // 기본 요금만 pay에 저장
                pay = fees[1];
            }
                
            // 그 외의 경우
            else {
                // 공식대로 요금 계산 후 pay에 저장
                pay = fees[1] + (int) Math.ceil((double) (carsStayTime.get(num) - fees[0]) / fees[2]) * fees[3];
            }
            
            // 저장된 pay는 정답 배열에 차례로 더해준다.
            answer[idx++] = pay;
        }
        
        return answer;
    }
    
    public int getMinutes (int hh, int mm) {
        return hh * 60 + mm;
    }
}
