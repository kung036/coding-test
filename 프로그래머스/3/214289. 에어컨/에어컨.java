import java.util.*;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        final int OFFSET = 10, SIZE = 51, INF = Integer.MAX_VALUE / 2;
        int n = onboard.length;
        int out = temperature + OFFSET;
        int lo = t1 + OFFSET, hi = t2 + OFFSET;

        int[] dp = new int[SIZE];
        Arrays.fill(dp, INF);
        dp[out] = 0;

        for (int i = 0; i < n - 1; i++) {
            int[] nxt = new int[SIZE];
            Arrays.fill(nxt, INF);
            for (int x = 0; x < SIZE; x++) {
                if (dp[x] >= INF) continue;

                // 에어컨 끔: 실외온도 쪽으로 1도 (같으면 그대로), 전력 0
                int off = x < out ? x + 1 : (x > out ? x - 1 : x);
                nxt[off] = Math.min(nxt[off], dp[x]);

                // 에어컨 켬: 희망온도 = x면 유지(b), 아니면 1도 이동(a)
                nxt[x] = Math.min(nxt[x], dp[x] + b);
                if (x + 1 < SIZE) nxt[x + 1] = Math.min(nxt[x + 1], dp[x] + a);
                if (x - 1 >= 0) nxt[x - 1] = Math.min(nxt[x - 1], dp[x] + a);
            }
            // 승객 탑승 시간대는 쾌적 범위만 허용
            if (onboard[i + 1] == 1) {
                for (int x = 0; x < SIZE; x++) if (x < lo || x > hi) nxt[x] = INF;
            }
            dp = nxt;
        }

        int ans = INF;
        for (int v : dp) ans = Math.min(ans, v);
        return ans;
    }
}