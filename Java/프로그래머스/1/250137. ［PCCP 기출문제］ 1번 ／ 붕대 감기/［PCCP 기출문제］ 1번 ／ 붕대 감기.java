class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];

        int cur = health;
        int combo = 0;
        int prevTime = 0;

        for (int[] attack : attacks) {
            int atkTime = attack[0];
            int atkDmg  = attack[1];

            // 이전 공격 ~ 현재 공격 사이 회복
            int healTime = atkTime - prevTime - 1;

            if (healTime > 0) {
                cur += healTime * x;

                // 추가 회복 횟수 계산
                int fullCycles = (combo + healTime) / t;
                int prevCycles = combo / t;
                cur += (fullCycles - prevCycles) * y;

                combo = (combo + healTime) % t;
            }

            cur = Math.min(cur, health);

            // 공격 받기
            cur -= atkDmg;
            combo = 0;

            if (cur <= 0) return -1;

            prevTime = atkTime;
        }

        return cur;
    }
}