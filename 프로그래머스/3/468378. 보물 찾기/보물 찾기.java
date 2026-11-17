import java.util.function.Function;

class Solution {
    public int solution(int[] depth, int money, Function<Integer, Integer> excavate) {
        int w = depth.length;
        long[][] f = new long[w + 2][w + 2];
        int[][] pick = new int[w + 2][w + 2];

        for (int len = 1; len <= w; len++) {
            for (int l = 1; l + len - 1 <= w; l++) {
                int r = l + len - 1;
                long best = Long.MAX_VALUE;
                for (int k = l; k <= r; k++) {
                    long left = k > l ? f[l][k - 1] : 0;
                    long right = k < r ? f[k + 1][r] : 0;
                    long cost = depth[k - 1] + Math.max(left, right);
                    if (cost < best) { best = cost; pick[l][r] = k; }
                }
                f[l][r] = best;
            }
        }

        int l = 1, r = w;
        while (l <= r) {
            int k = pick[l][r];
            int res = excavate.apply(k);
            if (res == 0) return k;
            if (res < 0) r = k - 1;
            else l = k + 1;
        }
        return 0;
    }
}