class Solution {
    public long solution(int w, int h) {
        long W = (long)w;
        long H = (long)h;
        
        // 전체 정사각형 개수에서 대각선이 지나가는 정사각형 개수를 뺌
        return W * H - (W + H - gcd(W, H));
    }
    
    // 최대공약수 구하는 함수
    private long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
