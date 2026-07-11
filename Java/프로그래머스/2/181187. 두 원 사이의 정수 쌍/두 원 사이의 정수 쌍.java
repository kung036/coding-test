public class Solution {
    public long solution(int r1, int r2) {
        long Q = 0;
        long r1sq = (long) r1 * r1;
        long r2sq = (long) r2 * r2;

        for (long x = 1; x <= r2; x++) {
            long maxY2 = r2sq - x * x;
            if (maxY2 < 1) continue; // y>=1 만족하는 y 없음

            long yMax = isqrt(maxY2);

            long minY2 = r1sq - x * x;
            long yMin;
            if (minY2 <= 0) {
                yMin = 1;
            } else {
                yMin = isqrt(minY2 - 1) + 1; // ceil(sqrt(minY2))
            }

            if (yMax >= yMin) {
                Q += (yMax - yMin + 1);
            }
        }

        return 4 * Q + 4L * (r2 - r1 + 1);
    }

    // 정수 제곱근 (부동소수점 오차 방지)
    private long isqrt(long n) {
        if (n < 0) return -1;
        long x = (long) Math.sqrt((double) n);
        while (x * x > n) x--;
        while ((x + 1) * (x + 1) <= n) x++;
        return x;
    }
}