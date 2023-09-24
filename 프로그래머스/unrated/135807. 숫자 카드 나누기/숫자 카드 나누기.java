import java.util.Arrays;

class Solution {
    /*
    두 배열을 정렬 후, 배열의 최대공약수를 구한다.
    그 최대공약수로 상대 배열에서 나눌 수 있는 수가 있는지 구한다.
    */
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int len_a = arrayA.length;
        int len_b = arrayB.length;
        
        int r_a = arrayA[0];
        for (int i=1;i<len_a;i++) {
            r_a = getGCD(r_a, arrayA[i]);
        }
        
        for (int i=0;i<len_b;i++) {
            if (arrayB[i] % r_a == 0) {
                r_a = 0;
                break;
            }
        }
        
        int r_b = arrayB[0];
        for (int i=1;i<len_b;i++) {
            r_b = getGCD(r_b, arrayB[i]);
        }
        
        for (int i=0;i<len_a;i++) {
            if (arrayA[i] % r_b == 0) {
                r_b = 0;
                break;
            }
        }
        
        return Math.max(r_a, r_b);
    }
    
    int getGCD (int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        
        return a;
    }
}