class Solution {
    public int solution(int n) {
        // N=1 -> 1
        // N=2 -> 2
        // N=3 -> 3
        // N=4 -> 5
        // N=5 -> 1+4*3 = 1 + 12 =13
        
        // tile[N] = tile[N-2] + tile[N-1]
        
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1000000007;
        }
        
        return dp[n];
    }
}