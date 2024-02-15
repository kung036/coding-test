package programmers;

// dp
public class Level2_3xn_타일링 {
    public long solution(int n) {
        long[] dp = new long[5001];

        // 홀수인 경우
        if(n%2 == 1) return 0;

        // 짝수이 경우
        // 점화식 : f(n) = 3*f(n-2) + 2*f(n-4) + 2*f(n-6) + ... + 2*f(2) + 2
        dp[0] = 1;
        dp[2] = 3;
        int mod = 1000000007;

        // 모듈러 분배규칙 이용
        for(int i = 4; i <= n; i+=2){
            dp[i] = (dp[i-2]*4%mod -dp[i-4]%mod +mod)%mod;
        }

        return dp[n];
    }
}
