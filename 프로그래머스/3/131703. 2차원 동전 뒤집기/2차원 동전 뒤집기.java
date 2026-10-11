class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int n = beginning.length;
        int m = beginning[0].length;
        int answer = Integer.MAX_VALUE;

        for (int mask = 0; mask < (1 << n); mask++) {
            int count = Integer.bitCount(mask); // 뒤집은 행 수
            boolean ok = true;

            for (int j = 0; j < m && ok; j++) {
                int same = 0;
                for (int i = 0; i < n; i++) {
                    int cur = beginning[i][j] ^ ((mask >> i) & 1); // 행 뒤집기 반영
                    if (cur == target[i][j]) same++;
                }
                if (same == 0) count++;      // 열 전체가 다름 → 열 뒤집기
                else if (same != n) ok = false; // 섞여 있음 → 불가능
            }

            if (ok) answer = Math.min(answer, count);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}