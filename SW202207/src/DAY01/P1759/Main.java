package DAY01.P1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int l, c;
    static char[] alphas;
    static ArrayList<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        l = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine(), " ");

        alphas = new char[c];
        for (int i=0;i<c;i++) alphas[i] = stk.nextToken().charAt(0);

        Arrays.sort(alphas);

        answer = new ArrayList<String>();
        for (int i=0;i<c;i++) {
            if ((alphas[i] == 'a') || (alphas[i] == 'e') || (alphas[i] == 'i') || (alphas[i] == 'o') || (alphas[i] == 'u')) {
                dfs(1, 0, 1, i, String.valueOf(alphas[i]));
            }
            else dfs(1, 1, 0, i, String.valueOf(alphas[i]));
        }

        for (String s : answer) {
            System.out.println(s);
        }
    }

    static void dfs(int length, int ja, int mo, int current, String pwd) {
        // 1. 체크인 ; 생략 가능
        // 2. 목적지인가? ; index==l + 자음2모음1 포함
        if (length == l) {
            if (ja >= 2 && mo >= 1) {
                answer.add(pwd);
            }
        }
        // 3. 아니라면 연결된 곳을 순회
        else {
            for (int i=current+1;i<c;i++) {
                if ((alphas[i] == 'a') || (alphas[i] == 'e') || (alphas[i] == 'i') || (alphas[i] == 'o') || (alphas[i] == 'u')) {
                    dfs(length+1, ja, mo+1, i, pwd+alphas[i]);
                }
                else {
                    dfs(length+1, ja+1, mo, i, pwd+alphas[i]);
                }
            }
            // 4. 갈 수 있는가 ? ; 방문 여부? 다 됨
            // 5. 간다
        }
        // 6. 체크아웃
    }

}
