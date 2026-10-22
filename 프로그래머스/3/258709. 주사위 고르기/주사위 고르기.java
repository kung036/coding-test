import java.util.*;

class Solution {
    public int[] solution(int[][] dice) {
        int n = dice.length;
        int half = n / 2;
        long bestWin = -1;
        int bestMask = 0;

        for (int mask = 0; mask < (1 << n); mask++) {
            if (Integer.bitCount(mask) != half) continue;

            List<int[]> a = new ArrayList<>();
            List<int[]> b = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) a.add(dice[i]);
                else b.add(dice[i]);
            }

            long[] cntA = sumCount(a);
            long[] cntB = sumCount(b);

            // B의 합이 s 미만인 경우의 수 (누적합)
            long[] less = new long[cntB.length + 1];
            for (int s = 0; s < cntB.length; s++) less[s + 1] = less[s] + cntB[s];

            long win = 0;
            for (int s = 0; s < cntA.length; s++) {
                if (cntA[s] == 0) continue;
                win += cntA[s] * less[s]; // less[s] = B합이 0..s-1인 경우의 수
            }

            if (win > bestWin) {
                bestWin = win;
                bestMask = mask;
            }
        }

        int[] answer = new int[half];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if ((bestMask & (1 << i)) != 0) answer[idx++] = i + 1;
        }
        return answer;
    }

    // 주어진 주사위들을 모두 굴렸을 때 나오는 합별 경우의 수
    private long[] sumCount(List<int[]> ds) {
        long[] cur = new long[501];
        cur[0] = 1;
        for (int[] d : ds) {
            long[] next = new long[501];
            for (int s = 0; s <= 500; s++) {
                if (cur[s] == 0) continue;
                for (int face : d) {
                    if (s + face <= 500) next[s + face] += cur[s];
                }
            }
            cur = next;
        }
        return cur;
    }
}