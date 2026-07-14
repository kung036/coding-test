import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin + 1)];
        final long LIMIT = 10_000_000L;

        for (long now = begin; now <= end; now++) {
            int idx = (int)(now - begin);
            long best = 1;
            
            for (long div = 2; div * div <= now; div++) {
                if (now % div == 0) {
                    long big = now / div;
                    if (big <= LIMIT) {
                        best = big;
                        break;
                    } else if (div <= LIMIT) {
                        best = div;
                    }
                }
            }
            answer[idx] = (int) best;
        }

        if (begin == 1) answer[0] = 0;

        return answer;
    }
}