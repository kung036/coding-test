import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int wa = scores[0][0], wb = scores[0][1];
        int wSum = wa + wb;

        // 근무태도 내림차순, 같으면 동료평가 오름차순
        Arrays.sort(scores, (x, y) -> x[0] != y[0] ? y[0] - x[0] : x[1] - y[1]);

        int maxB = 0;
        int rank = 1;

        for (int[] s : scores) {
            if (s[1] < maxB) {
                // 둘 다 낮은 사원이 존재 → 인센티브 X
                if (s[0] == wa && s[1] == wb) return -1;
                continue;
            }
            maxB = Math.max(maxB, s[1]);
            if (s[0] + s[1] > wSum) rank++;
        }
        return rank;
    }
}