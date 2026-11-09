class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        // 최악: a+b = 2e9, w = 1, t = 1e5 → 왕복 2e5씩 2e9번
        long right = 400_000_000_000_000L;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (canCarry(mid, a, b, g, s, w, t)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    private boolean canCarry(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long gold = 0, silver = 0, total = 0;

        for (int i = 0; i < g.length; i++) {
            long roundTrip = 2L * t[i];
            long count = time / roundTrip;
            if (time % roundTrip >= t[i]) count++;   // 편도 한 번 추가

            long capacity = count * w[i];

            gold   += Math.min(g[i], capacity);
            silver += Math.min(s[i], capacity);
            total  += Math.min((long) g[i] + s[i], capacity);
        }

        return gold >= a && silver >= b && total >= (long) a + b;
    }
}