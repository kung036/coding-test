package backjoon;

import java.util.Scanner;

public class No1823 {
    static int[] values;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        values = new int[N];
        dp = new int[N][N];
        int left = 0, right = N-1;
        int sum = 0;

        // N개의 가치 입력
        for(int i=0; i<N; i++) {
            values[i] = sc.nextInt();
        }

        sum = dfs(left, right,1);

        System.out.println(sum);
        sc.close();
    }

    // 투포인터, dfs, dp
    static int dfs(int left, int right, int i) {
        // 투포인터
        if(left>right) return 0;

        // dp
        if(dp[left][right] != 0) return dp[left][right];

        int tmp_left = dfs(left+1, right, i+1) + values[left]*i;
        int tmp_right = dfs(left, right-1, i+1) + values[right]*i;

        dp[left][right] = Math.max(tmp_left, tmp_right);

        return dp[left][right];
    }
}
