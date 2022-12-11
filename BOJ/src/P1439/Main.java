package P1439;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BOJ/src/P1439/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        // 바뀌는 영역 count
        int answer = 0;

        // charArr에 s를 char array로 바꿔 넣어준다.
        char[] charArr = s.toCharArray();
        // 첫번째를 기준으로 모든 숫자를 바꿔줄 것이기 때문에 change_to에 미리 넣어준다.
        char change_to = charArr[0];

        int len = s.length();

        // 배열 돌며 change_to에 맞지 않는 문자를 마주치면 true로 바꾸며, 현재 위치가 앞에 것에 이어 바뀌고 있는지를 체크해주는 boolean 변수
        boolean isChanging = false;

        // 배열 순회
        for (int i=0;i<len;i++) {
            // 현재 위치의 문자가 change_to 와 맞지 않으며
            if (charArr[i] != change_to) {
                // 현 위치에서 처음 다른 문자를 마주한 것이면
                if (!isChanging) {
                    // 뒤의 문자도 같이 바꾸겠다는, 바꿔주는 동일한 영역이라는 표시의 isChanging 를 true 로 설정해준다.
                    isChanging = true;
                    // 그리고 answer 에도 1을 더해준다.
                    answer++;
                }
                // 현재 위치 문자가 change_to 와 같다면
            } else {
                // isChanging true 일 경우만 다시 false 로 바꿔준다.
                if (isChanging) {
                    isChanging = false;
                }
            }
        }

        System.out.println(answer);
    }
}
