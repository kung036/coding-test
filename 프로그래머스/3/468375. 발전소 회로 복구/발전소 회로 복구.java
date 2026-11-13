import java.util.*;

class Solution {
    static final int INF = 1_000_000_000;

    public int solution(int h, String[] grid, int[][] panels, int[][] seqs) {
        int n = grid.length, m = grid[0].length();
        int k = panels.length;

        // 엘리베이터 위치 찾기
        int er = 0, ec = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == '@') { er = i; ec = j; }
            }
        }

        // 각 패널에서의 BFS 거리 + 엘리베이터까지의 거리
        int[][][] bfs = new int[k][][];
        for (int i = 0; i < k; i++) {
            bfs[i] = bfs(grid, n, m, panels[i][1] - 1, panels[i][2] - 1);
        }
        int[] toElev = new int[k];
        for (int i = 0; i < k; i++) {
            toElev[i] = bfs[i][er][ec];
        }

        // 패널 간 거리
        long[][] dist = new long[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (panels[i][0] == panels[j][0]) {
                    dist[i][j] = bfs[i][panels[j][1] - 1][panels[j][2] - 1];
                } else {
                    dist[i][j] = (long) toElev[i] + Math.abs(panels[i][0] - panels[j][0]) + toElev[j];
                }
            }
        }

        // 선행 조건 마스크
        int[] pre = new int[k];
        for (int[] s : seqs) {
            pre[s[1] - 1] |= 1 << (s[0] - 1);
        }

        // 비트마스크 DP
        int full = (1 << k) - 1;
        long[][] dp = new long[1 << k][k];
        for (long[] row : dp) Arrays.fill(row, Long.MAX_VALUE / 4);
        dp[0][0] = 0; // 1번 패널 위치에서 시작, 아직 아무것도 활성화 안 함

        for (int mask = 0; mask <= full; mask++) {
            for (int last = 0; last < k; last++) {
                long cur = dp[mask][last];
                if (cur >= Long.MAX_VALUE / 4) continue;
                for (int nxt = 0; nxt < k; nxt++) {
                    if ((mask & (1 << nxt)) != 0) continue;
                    if ((pre[nxt] & mask) != pre[nxt]) continue;
                    long d = dist[last][nxt];
                    if (d >= INF) continue;
                    int nm = mask | (1 << nxt);
                    if (cur + d < dp[nm][nxt]) dp[nm][nxt] = cur + d;
                }
            }
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < k; i++) ans = Math.min(ans, dp[full][i]);
        return (int) ans;
    }

    private int[][] bfs(String[] grid, int n, int m, int sr, int sc) {
        int[][] d = new int[n][m];
        for (int[] row : d) Arrays.fill(row, INF);
        ArrayDeque<int[]> q = new ArrayDeque<>();
        d[sr][sc] = 0;
        q.add(new int[]{sr, sc});
        int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int t = 0; t < 4; t++) {
                int nr = p[0] + dr[t], nc = p[1] + dc[t];
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (grid[nr].charAt(nc) == '#') continue;
                if (d[nr][nc] != INF) continue;
                d[nr][nc] = d[p[0]][p[1]] + 1;
                q.add(new int[]{nr, nc});
            }
        }
        return d;
    }
}