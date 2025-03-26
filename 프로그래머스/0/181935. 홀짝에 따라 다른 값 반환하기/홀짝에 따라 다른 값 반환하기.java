class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n%2 == 0) { // 짝수
            for(int i=2; i<=n; i+=2) {
                answer += i*i;
            }
        } else { // 홀수
            for(int i=1; i<=n; i+=2) {
                answer += i;
            }
        }
        return answer;
    }
}