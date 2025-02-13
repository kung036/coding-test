class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(long x = 0; x <= d; x += k) {
            // 피타고라스 정리 활용: x^2 + y^2 = d^2
            long maxY = (long)Math.sqrt((long)d*d - x*x);
            answer += (maxY/k) + 1;
        }
        
        return answer;
    }
}
