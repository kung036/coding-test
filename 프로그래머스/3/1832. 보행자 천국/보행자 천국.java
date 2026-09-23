class Solution {
    public int solution(int m, int n, int[][] city_map) {
        final int MOD = 20170805;

        // R[i][j]: (i,j)에 "오른쪽 이동"으로 도착한 경로 수
        // D[i][j]: (i,j)에 "아래 이동"으로 도착한 경로 수
        // total[i][j] = R[i][j] + D[i][j]
        long[][] R = new long[m][n];
        long[][] D = new long[m][n];
        long[][] total = new long[m][n];

        total[0][0] = 1; // 출발점은 city_map[0][0] == 0 이 보장됨

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                if (city_map[i][j] == 1) {
                    // 통행 불가 칸 -> 그대로 0 (배열 기본값)
                    continue;
                }

                long r = 0, d = 0;

                // 왼쪽 칸에서 오른쪽으로 이동해 들어오는 경우
                if (j > 0) {
                    if (city_map[i][j - 1] == 2) {
                        // 2였다면 직진(오른쪽으로 왔으면 오른쪽으로만) 만 허용됨
                        r = R[i][j - 1];
                    } else {
                        r = total[i][j - 1];
                    }
                }

                // 위 칸에서 아래로 이동해 들어오는 경우
                if (i > 0) {
                    if (city_map[i - 1][j] == 2) {
                        d = D[i - 1][j];
                    } else {
                        d = total[i - 1][j];
                    }
                }

                R[i][j] = r % MOD;
                D[i][j] = d % MOD;
                total[i][j] = (r + d) % MOD;
            }
        }

        return (int) total[m - 1][n - 1];
    }
}