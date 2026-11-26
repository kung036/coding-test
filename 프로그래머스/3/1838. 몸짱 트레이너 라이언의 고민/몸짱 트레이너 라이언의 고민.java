class Solution {
    public int solution(int n, int m, int[][] timetable) {
        int[] cnt = new int[1321];
        int max = 0;
        for (int i = 0; i < m; i++)
            for (int t = timetable[i][0]; t <= timetable[i][1]; t++)
                max = Math.max(max, ++cnt[t]);

        if (max <= 1) return 0;

        for (int d = 2 * (n - 1); d > 0; d--)
            if (canPlace(n, d, max)) return d;
        return 0;
    }

    private boolean canPlace(int n, int d, int need) {
        for (int start = 0; start < n * n; start++) {
            int[] r = new int[n * n];
            int[] c = new int[n * n];
            int size = 0;
            for (int p = start; p < n * n; p++) {
                int y = p / n, x = p % n;
                boolean ok = true;
                for (int i = 0; i < size && ok; i++)
                    ok = Math.abs(y - r[i]) + Math.abs(x - c[i]) >= d;
                if (!ok) continue;
                r[size] = y;
                c[size++] = x;
                if (size >= need) return true;
            }
        }
        return false;
    }
}