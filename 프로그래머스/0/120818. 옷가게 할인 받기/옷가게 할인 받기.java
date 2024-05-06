class Solution {
    public int solution(int price) {
        int answer = 0;
        
        double discount_per = 1;
        if (500000 <= price) discount_per = 0.8;
        else if (300000 <= price) discount_per = 0.9;
        else if (100000 <= price) discount_per = 0.95;
        
        return (int)(price * discount_per);
    }
}