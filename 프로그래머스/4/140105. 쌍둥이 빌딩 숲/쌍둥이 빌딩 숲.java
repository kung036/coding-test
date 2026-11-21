class Solution {
    public int solution(int n, int count) {
        final long MOD = 1_000_000_007L;
        long[][] dp = new long[n + 1][n + 2];
        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 맨 앞에 끼우면 새로 보이는 빌딩 +1, 그 외 2i-2곳에 끼우면 가려짐
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j] * (2L * i - 2)) % MOD;
            }
        }
        return (int) dp[n][count];
    }
}