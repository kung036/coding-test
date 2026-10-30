class Solution {
    int n, m;
    int[][] maze;
    boolean[][] visR, visB;
    int rgx, rgy, bgx, bgy; // 도착 칸
    int best = Integer.MAX_VALUE;
    final int[] dx = {-1, 1, 0, 0};
    final int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maze) {
        this.maze = maze;
        n = maze.length;
        m = maze[0].length;
        visR = new boolean[n][m];
        visB = new boolean[n][m];

        int rsx = 0, rsy = 0, bsx = 0, bsy = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) { rsx = i; rsy = j; }
                else if (maze[i][j] == 2) { bsx = i; bsy = j; }
                else if (maze[i][j] == 3) { rgx = i; rgy = j; }
                else if (maze[i][j] == 4) { bgx = i; bgy = j; }
            }
        }

        visR[rsx][rsy] = true;
        visB[bsx][bsy] = true;
        dfs(rsx, rsy, bsx, bsy, 0);

        return best == Integer.MAX_VALUE ? 0 : best;
    }

    private void dfs(int rx, int ry, int bx, int by, int turn) {
        if (turn >= best) return; // 가지치기
        boolean rDone = (rx == rgx && ry == rgy);
        boolean bDone = (bx == bgx && by == bgy);
        if (rDone && bDone) {
            best = turn;
            return;
        }

        // 각 수레의 이동 후보 (도착한 수레는 제자리 고정)
        int rc = rDone ? 1 : 4;
        int bc = bDone ? 1 : 4;

        for (int i = 0; i < rc; i++) {
            int nrx = rx, nry = ry;
            if (!rDone) {
                nrx = rx + dx[i];
                nry = ry + dy[i];
                if (!can(nrx, nry, visR)) continue;
            }

            for (int j = 0; j < bc; j++) {
                int nbx = bx, nby = by;
                if (!bDone) {
                    nbx = bx + dx[j];
                    nby = by + dy[j];
                    if (!can(nbx, nby, visB)) continue;
                }

                // 같은 칸으로 동시에 이동 금지
                if (nrx == nbx && nry == nby) continue;
                // 서로 자리 교환 금지
                if (nrx == bx && nry == by && nbx == rx && nby == ry) continue;

                if (!rDone) visR[nrx][nry] = true;
                if (!bDone) visB[nbx][nby] = true;

                dfs(nrx, nry, nbx, nby, turn + 1);

                if (!rDone) visR[nrx][nry] = false;
                if (!bDone) visB[nbx][nby] = false;
            }
        }
    }

    private boolean can(int x, int y, boolean[][] vis) {
        return x >= 0 && x < n && y >= 0 && y < m && maze[x][y] != 5 && !vis[x][y];
    }
}