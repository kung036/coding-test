import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int lo = 1;
        int hi = Arrays.stream(diffs).max().getAsInt();

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (canSolve(diffs, times, limit, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private boolean canSolve(int[] diffs, int[] times, long limit, int level) {
        long total = 0;

        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            long timeCur = times[i];
            long timePrev = (i > 0) ? times[i - 1] : 0;

            if (diff <= level) {
                total += timeCur;
            } else {
                long mistakes = diff - level;
                total += mistakes * (timeCur + timePrev) + timeCur;
            }

            if (total > limit) return false; // 조기 종료
        }

        return true;
    }
}