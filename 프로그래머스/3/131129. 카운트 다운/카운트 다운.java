import java.util.*;

class Solution {
    public int[] solution(int target) {
        // 가능한 던지기 (점수, 싱글/불 여부)
        List<int[]> throwsList = new ArrayList<>();
        for (int k = 1; k <= 20; k++) {
            throwsList.add(new int[]{k, 1});      // 싱글
            throwsList.add(new int[]{k * 2, 0});  // 더블
            throwsList.add(new int[]{k * 3, 0});  // 트리플
        }
        throwsList.add(new int[]{50, 1});         // 불

        final int INF = Integer.MAX_VALUE;
        // dp[i] = {최소 다트 수, 그때 싱글/불 최대 개수}
        int[][] dp = new int[target + 1][2];
        for (int i = 1; i <= target; i++) dp[i][0] = INF;

        for (int i = 1; i <= target; i++) {
            for (int[] t : throwsList) {
                int prev = i - t[0];
                if (prev < 0 || dp[prev][0] == INF) continue;

                int darts = dp[prev][0] + 1;
                int sb = dp[prev][1] + t[1];

                if (darts < dp[i][0] || (darts == dp[i][0] && sb > dp[i][1])) {
                    dp[i][0] = darts;
                    dp[i][1] = sb;
                }
            }
        }

        return dp[target];
    }
}