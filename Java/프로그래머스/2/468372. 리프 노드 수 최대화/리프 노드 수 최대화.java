class Solution {
    public int solution(int dist_limit, int split_limit) {
        long D = dist_limit;
        long S = split_limit;

        long[] pow2 = new long[32];
        pow2[0] = 1;
        for (int i = 1; i < 32; i++) pow2[i] = pow2[i - 1] * 2;

        long[] pow3 = new long[21];
        pow3[0] = 1;
        for (int i = 1; i < 21; i++) pow3[i] = pow3[i - 1] * 3;

        long best = 1; // 분배 노드 없이 리프 1개 (기본값)

        for (int x = 0; x < 32 && pow2[x] <= S; x++) {
            for (int y = 0; y < 21 && pow2[x] * pow3[y] <= S; y++) {
                long N = pow2[x] * pow3[y];
                long cost = (pow2[x] - 1) + pow2[x] * (pow3[y] - 1) / 2;
                if (cost > D) break; // y가 커질수록 cost도 커지므로 이후는 다 불가능

                long R = D - cost; // 남은 분배 노드 예산
                long leaves = N;   // 더 확장 안 하는 경우

                if (N * 3 <= S) {
                    long k = Math.min(N, R); // 다음 레벨로 확장할 노드 수
                    leaves = Math.max(leaves, N + k * 2); // 확장된 노드당 리프 +2 순증가
                } else if (N * 2 <= S) {
                    long k = Math.min(N, R);
                    leaves = Math.max(leaves, N + k);
                }

                best = Math.max(best, leaves);
            }
        }

        return (int) best;
    }
}