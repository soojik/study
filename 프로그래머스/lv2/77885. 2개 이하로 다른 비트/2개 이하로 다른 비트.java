class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        // 짝수는 간단 .. 끝자리가 0이니 이것만 1로 바꿔주면(1을 더해주면 정답)
        // 홀수는 오른쪽에서 가장 처음으로 나오는 0을 오른쪽 1과 바꿔주면 된다. 그러면 2자리 다른 최솟값을 구할 수 있다.
        
        // answer_idx 는 answer에 차례로 답을 넣기위한 인덱스(포인터)
        int answer_idx = 0;
        
        // 처음으로 나온 0의 인덱스(자리)
        int first_zero;
        
        // numbers 순회
        for (long num : numbers) {
            // 짝수라면 1 더하고 정답 배열에 추가
            if (num % 2 == 0) {
                answer[answer_idx++] = num + 1;
                continue;
            }
            
            // num을 binary 값으로 바꾼다.
            String num_bin = Long.toBinaryString(num);
            
            // 0이 있다면
            if (num_bin.contains("0")) {
                // 마지막 0의 인덱스(오른쪽에 가장 가까운 0)를 first_zero로 지정
                first_zero = num_bin.length() - num_bin.lastIndexOf("0") - 1;
            }
            // 0이 없다면
            else {
                // 0은 binary 로 변환한 num 값의 길이에 위치한다.
                // e.g.) 7 -> 111 -> 0111
                first_zero = num_bin.length();
            }
            
            // 나온 0 자리를 1로, 그 전 자리의 1을 0으로 바꾸니까 2^전 자리 만큼 더해주면 된다.
            answer[answer_idx++] = num + (long) Math.pow(2, first_zero - 1);
        }
        
        /*  10~11번 시간초과
        
        // idx 와 num 의 XOR 값에 대한 bit 개수가 다른 비트의 개수가 된다.
        long result_bit;
        for (long num : numbers) {
            // num 보다 큰 값 중
            long idx = num + 1;
            
            while (true) {
                result_bit = Long.bitCount(idx ^ num);
                // 다른 비트 개수가 1 또는 2 라면
                if (result_bit == 1 || result_bit == 2) {
                    // 정답배열에 넣어주고
                    answer[answer_idx++] = idx;
                    // 탐색 종료
                    break;
                }
                // 위 if 문에서 걸리지 않으면 수 1증가 시켜서 다음 탐색 진행
                ++idx;
            }
        }
        */
        
        return answer;
    }
}