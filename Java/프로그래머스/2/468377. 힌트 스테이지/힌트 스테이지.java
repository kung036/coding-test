class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int n = cost.length;
        int m = n - 1; // 번들 구매 여부를 결정할 스테이지 수 (1 ~ n-1)
        long best = Long.MAX_VALUE;

        for (int mask = 0; mask < (1 << m); mask++) {
            int[] count = new int[n + 1]; // 1-indexed 힌트권 보유 개수
            long total = 0;

            for (int stage = 1; stage <= n; stage++) {
                int used = Math.min(count[stage], n - 1);
                total += cost[stage - 1][used];

                if (stage < n) {
                    // stage 번째 비트로 구매 여부 결정
                    if (((mask >> (stage - 1)) & 1) == 1) {
                        int[] bundle = hint[stage - 1];
                        total += bundle[0]; // 구매 가격
                        for (int k = 1; k < bundle.length; k++) {
                            int ticketNum = bundle[k];
                            count[ticketNum]++;
                        }
                    }
                }
            }

            best = Math.min(best, total);
        }

        return (int) best;
    }
}