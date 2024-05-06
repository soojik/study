class Solution {
    public int solution(int n, int k) {
        return n*12000 + (Math.max(0, k-n/10) * 2000);
    }
}