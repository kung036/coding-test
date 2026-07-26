class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        int[] periods = new int[n];
        long lcm = 1;

        for (int i = 0; i < n; i++) {
            int period = signals[i][0] + signals[i][1] + signals[i][2];
            periods[i] = period;
            lcm = lcm(lcm, period);
        }

        for (long t = 1; t <= lcm; t++) {
            boolean allYellow = true;
            for (int i = 0; i < n; i++) {
                int pos = (int) ((t - 1) % periods[i]);
                int G = signals[i][0];
                int Y = signals[i][1];
                if (!(pos >= G && pos < G + Y)) {
                    allYellow = false;
                    break;
                }
            }
            if (allYellow) return (int) t;
        }

        return -1;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}