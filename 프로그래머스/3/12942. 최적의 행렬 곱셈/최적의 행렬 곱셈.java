class Solution {
    public int solution(int[][] matrix_sizes) {
        int n = matrix_sizes.length;

        // 치수 배열: i번째 행렬 = p[i] x p[i+1]
        int[] p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i] = matrix_sizes[i][0];
        }
        p[n] = matrix_sizes[n - 1][1];

        long[][] dp = new long[n][n]; // 길이 1 구간은 0

        for (int len = 2; len <= n; len++) {          // 구간 길이
            for (int i = 0; i + len - 1 < n; i++) {   // 시작
                int j = i + len - 1;                   // 끝
                dp[i][j] = Long.MAX_VALUE;
                for (int k = i; k < j; k++) {          // 분할 지점
                    long cost = dp[i][k] + dp[k + 1][j]
                              + (long) p[i] * p[k + 1] * p[j + 1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return (int) dp[0][n - 1];
    }
}