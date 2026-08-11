class Solution {
    public int solution(int[] sticker) {
        int n = sticker.length;
        if (n == 1) return sticker[0];
        if (n == 2) return Math.max(sticker[0], sticker[1]);

        int case1 = rob(sticker, 0, n - 2);     // 마지막 제외
        int case2 = rob(sticker, 1, n - 1);     // 첫 번째 제외
        return Math.max(case1, case2);
    }

    private int rob(int[] sticker, int start, int end) {
        int incl = 0, excl = 0;
        for (int i = start; i <= end; i++) {
            int newIncl = excl + sticker[i];
            excl = Math.max(incl, excl);
            incl = newIncl;
        }
        return Math.max(incl, excl);
    }
}