class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        // 도착점 (x, y)에서 쿼리를 거꾸로 따라가며 "시작 가능한 범위"를 구한다.
        long r1 = x, r2 = x, c1 = y, c2 = y;

        for (int i = queries.length - 1; i >= 0; i--) {
            int cmd = queries[i][0];
            long dx = queries[i][1];

            if (cmd == 0) {            // 정방향: 열 감소(왼쪽) -> 역방향: 열 증가
                if (c1 == 0) c2 = Math.min(m - 1, c2 + dx);
                else { c1 += dx; c2 += dx; }
                if (c1 > m - 1) return 0;
                c2 = Math.min(c2, m - 1);
            } else if (cmd == 1) {     // 정방향: 열 증가(오른쪽) -> 역방향: 열 감소
                if (c2 == m - 1) c1 = Math.max(0, c1 - dx);
                else { c1 -= dx; c2 -= dx; }
                if (c2 < 0) return 0;
                c1 = Math.max(c1, 0);
            } else if (cmd == 2) {     // 정방향: 행 감소(위) -> 역방향: 행 증가
                if (r1 == 0) r2 = Math.min(n - 1, r2 + dx);
                else { r1 += dx; r2 += dx; }
                if (r1 > n - 1) return 0;
                r2 = Math.min(r2, n - 1);
            } else {                   // 정방향: 행 증가(아래) -> 역방향: 행 감소
                if (r2 == n - 1) r1 = Math.max(0, r1 - dx);
                else { r1 -= dx; r2 -= dx; }
                if (r2 < 0) return 0;
                r1 = Math.max(r1, 0);
            }
        }
        return (r2 - r1 + 1) * (c2 - c1 + 1);
    }
}