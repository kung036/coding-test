class Solution {
    public int solution(int n) {
        // 최소공배수 구하기
        int answer = 0;
        for(int i=6; true; i+=6) {
            if(i%n==0) {
                answer = i/6;
                break;
            }
        }
        
        return answer;
    }
}