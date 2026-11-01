import java.util.*;

class Solution {
    public long solution(int[][] land, int P, int Q) {
        int n = land.length;
        int total = n * n;
        long[] h = new long[total];
        int idx = 0;
        for (int[] row : land) {
            for (int v : row) h[idx++] = v;
        }
        Arrays.sort(h);

        // prefix[i] = h[0] + ... + h[i-1]
        long[] prefix = new long[total + 1];
        for (int i = 0; i < total; i++) prefix[i + 1] = prefix[i] + h[i];

        long best = Long.MAX_VALUE;
        // 비용 함수는 높이에 대해 구간별 직선이므로, 최적 높이는 기존 칸 높이 중 하나다
        for (int i = 0; i < total; i++) {
            if (i > 0 && h[i] == h[i - 1]) continue; // 같은 높이는 한 번만

            long target = h[i];
            long belowCnt = i;                       // target보다 낮은 칸 개수
            long belowSum = prefix[i];
            long aboveCnt = total - i;               // target 이상인 칸 (같은 높이는 비용 0)
            long aboveSum = prefix[total] - prefix[i];

            long add = target * belowCnt - belowSum;        // 추가할 블록 수
            long remove = aboveSum - target * aboveCnt;     // 제거할 블록 수

            best = Math.min(best, add * P + remove * Q);
        }
        return best;
    }
}