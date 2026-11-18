import java.util.*;

class Solution {
    public int solution(int[] sales, int[][] links) {
        int n = sales.length;
        List<Integer>[] child = new List[n + 1];
        for (int i = 1; i <= n; i++) child[i] = new ArrayList<>();
        for (int[] e : links) child[e[0]].add(e[1]);

        // 재귀 없이 처리: 루트부터 순서를 구한 뒤 거꾸로 DP
        int[] order = new int[n];
        int head = 0, tail = 0;
        order[tail++] = 1;
        while (head < tail) {
            int v = order[head++];
            for (int c : child[v]) order[tail++] = c;
        }

        int[] dp0 = new int[n + 1]; // v 불참
        int[] dp1 = new int[n + 1]; // v 참석
        for (int idx = n - 1; idx >= 0; idx--) {
            int v = order[idx];
            dp1[v] = sales[v - 1];
            if (child[v].isEmpty()) { dp0[v] = 0; continue; }

            int sum = 0, minDiff = Integer.MAX_VALUE;
            boolean attend = false;
            for (int c : child[v]) {
                sum += Math.min(dp0[c], dp1[c]);
                if (dp1[c] <= dp0[c]) attend = true;
                minDiff = Math.min(minDiff, dp1[c] - dp0[c]);
            }
            dp1[v] += sum;
            dp0[v] = attend ? sum : sum + minDiff;
        }
        return Math.min(dp0[1], dp1[1]);
    }
}