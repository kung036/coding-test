class Solution {
    public long solution(int n, long l, long r) {
        long[] pow5 = new long[n];
        pow5[0] = 1;
        for (int i = 1; i < n; i++) {
            pow5[i] = pow5[i - 1] * 5;
        }

        long count = 0;
        for (long p = l; p <= r; p++) {
            long idx = p - 1; // 1-based -> 0-based 변환
            if (isOne(idx, n, pow5)) count++;
        }
        return count;
    }

    private boolean isOne(long idx, int n, long[] pow5) {
        for (int level = 0; level < n; level++) {
            long digit = (idx / pow5[level]) % 5;
            if (digit == 2) return false;
        }
        return true;
    }
}