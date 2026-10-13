class Solution {
    public int solution(int n, int[] tops) {
        final int MOD = 10007;
        int a = 1; // 현재 U가 비어 있는 경우의 수
        int b = 0; // 현재 U가 앞의 마름모로 채워진 경우의 수

        for (int i = 0; i < n; i++) {
            int t = tops[i];
            int na = ((2 + t) * a + (1 + t) * b) % MOD;
            int nb = (a + b) % MOD;
            a = na;
            b = nb;
        }

        return (a + b) % MOD;
    }
}