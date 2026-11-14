import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        final int INF = 1_000_000;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] e : edge_list) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[][] dp = new int[k][n + 1];
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[0][gps_log[0]] = 0;

        for (int t = 1; t < k; t++) {
            for (int v = 1; v <= n; v++) {
                int best = dp[t - 1][v];              // 제자리에 머무는 경우
                for (int u : adj.get(v)) {
                    best = Math.min(best, dp[t - 1][u]);
                }
                if (best >= INF) continue;
                dp[t][v] = best + (gps_log[t] == v ? 0 : 1);
            }
        }

        int answer = dp[k - 1][gps_log[k - 1]];
        return answer >= INF ? -1 : answer;
    }
}