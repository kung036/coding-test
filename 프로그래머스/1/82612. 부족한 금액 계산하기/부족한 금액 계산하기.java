class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        for(int i=1; i<=count; i++) {
            answer += i * price;
        }
        
        if(answer > money) answer -= money;
        else answer = 0l;

        return answer;
    }
}