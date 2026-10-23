class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int target = n + 1;
        boolean[] hand = new boolean[n + 2];   // 손에 든 카드
        boolean[] pool = new boolean[n + 2];   // 뽑았지만 아직 안 가진 카드 (동전 내면 가질 수 있음)

        int idx = n / 3;
        for (int i = 0; i < idx; i++) hand[cards[i]] = true;

        int round = 1;
        while (idx < n) {
            pool[cards[idx]] = true;
            pool[cards[idx + 1]] = true;
            idx += 2;

            boolean done = false;

            // 1) 손패 안에서 짝 (동전 0개)
            for (int x = 1; x <= n && !done; x++) {
                if (hand[x] && hand[target - x]) {
                    hand[x] = false;
                    hand[target - x] = false;
                    done = true;
                }
            }

            // 2) 손패 1장 + 뽑은 카드 1장 (동전 1개)
            if (!done && coin >= 1) {
                for (int x = 1; x <= n && !done; x++) {
                    if (hand[x] && pool[target - x]) {
                        hand[x] = false;
                        pool[target - x] = false;
                        coin -= 1;
                        done = true;
                    }
                }
            }

            // 3) 뽑은 카드 2장 (동전 2개)
            if (!done && coin >= 2) {
                for (int x = 1; x <= n && !done; x++) {
                    if (pool[x] && pool[target - x]) {
                        pool[x] = false;
                        pool[target - x] = false;
                        coin -= 2;
                        done = true;
                    }
                }
            }

            if (!done) break;
            round++;
        }
        return round;
    }
}