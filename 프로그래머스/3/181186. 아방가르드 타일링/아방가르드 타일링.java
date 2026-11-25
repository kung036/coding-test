class Solution {
    public int solution(int n) {
        final long MOD = 1_000_000_007L;
        long[] dp = new long[Math.max(n + 1, 4)];
        dp[0] = 1; dp[1] = 1; dp[2] = 3; dp[3] = 10;

        for (int i = 4; i <= n; i++) {
            long v = dp[i - 1] + 2 * dp[i - 2] + 6 * dp[i - 3] + dp[i - 4];
            if (i >= 6) v -= dp[i - 6];
            dp[i] = ((v % MOD) + MOD) % MOD;
        }
        return (int) dp[n];
    }
}