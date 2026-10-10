class Solution {
    public int solution(int n, int[] cores) {
        int len = cores.length;
        if (n <= len) return n;

        int remain = n - len; // 시간 0에 시작한 작업 제외
        long lo = 0, hi = 10000L * remain;

        while (lo < hi) {
            long mid = (lo + hi) / 2;
            long cnt = 0;
            for (int c : cores) cnt += mid / c;
            if (cnt >= remain) hi = mid;
            else lo = mid + 1;
        }

        long t = lo;
        long done = 0;
        for (int c : cores) done += (t - 1) / c; // t-1 시점까지 시작된 작업

        long left = remain - done;
        for (int i = 0; i < len; i++) {
            if (t % cores[i] == 0) {
                left--;
                if (left == 0) return i + 1;
            }
        }
        return 0;
    }
}