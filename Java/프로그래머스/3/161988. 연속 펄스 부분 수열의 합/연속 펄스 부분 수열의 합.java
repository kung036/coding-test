class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[] p1 = new long[n];
        for (int i = 0; i < n; i++) {
            p1[i] = (i % 2 == 0) ? sequence[i] : -sequence[i];
        }

        long curMax = p1[0], maxSum = p1[0];
        long curMin = p1[0], minSum = p1[0];

        for (int i = 1; i < n; i++) {
            curMax = Math.max(p1[i], curMax + p1[i]);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(p1[i], curMin + p1[i]);
            minSum = Math.min(minSum, curMin);
        }

        return Math.max(maxSum, -minSum);
    }
}