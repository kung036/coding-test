import java.util.*;

class Solution {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public int solution(int[][] board, int r, int c) {
        return go(board, r, c);
    }

    // 현재 커서 (r, c)에서 남은 카드를 전부 없애는 최소 조작 횟수
    private int go(int[][] board, int r, int c) {
        int best = Integer.MAX_VALUE;
        boolean any = false;

        for (int t = 1; t <= 6; t++) {
            int[] p = find(board, t);
            if (p == null) continue;
            any = true;

            int r1 = p[0], c1 = p[1], r2 = p[2], c2 = p[3];

            // 카드 t 제거
            board[r1][c1] = 0;
            board[r2][c2] = 0;

            // (r,c) -> 카드1 -> 카드2 (+ Enter 2번)
            // BFS는 카드를 지운 뒤 보드가 아니라 "지우기 전" 보드 기준이어야 하므로 복원 후 계산
            board[r1][c1] = t;
            board[r2][c2] = t;
            int costA = bfs(board, r, c, r1, c1) + bfs(board, r1, c1, r2, c2) + 2;
            int costB = bfs(board, r, c, r2, c2) + bfs(board, r2, c2, r1, c1) + 2;
            board[r1][c1] = 0;
            board[r2][c2] = 0;

            best = Math.min(best, costA + go(board, r2, c2));
            best = Math.min(best, costB + go(board, r1, c1));

            // 복원
            board[r1][c1] = t;
            board[r2][c2] = t;
        }
        return any ? best : 0;
    }

    private int[] find(int[][] board, int t) {
        int[] res = new int[4];
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == t) {
                    res[cnt * 2] = i;
                    res[cnt * 2 + 1] = j;
                    cnt++;
                }
            }
        }
        return cnt == 2 ? res : null;
    }

    private int bfs(int[][] board, int sr, int sc, int tr, int tc) {
        if (sr == tr && sc == tc) return 0;
        int[][] dist = new int[4][4];
        for (int[] d : dist) Arrays.fill(d, -1);
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        dist[sr][sc] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0], cc = cur[1];
            if (cr == tr && cc == tc) return dist[cr][cc];

            for (int d = 0; d < 4; d++) {
                // 방향키 1칸 이동
                int nr = cr + dr[d], nc = cc + dc[d];
                if (in(nr, nc) && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[cr][cc] + 1;
                    q.add(new int[]{nr, nc});
                }

                // Ctrl + 방향키: 카드를 만나거나 끝까지 이동
                nr = cr;
                nc = cc;
                while (true) {
                    int tr2 = nr + dr[d], tc2 = nc + dc[d];
                    if (!in(tr2, tc2)) break;
                    nr = tr2;
                    nc = tc2;
                    if (board[nr][nc] != 0) break;
                }
                if (dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[cr][cc] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return Integer.MAX_VALUE / 4;
    }

    private boolean in(int r, int c) {
        return r >= 0 && r < 4 && c >= 0 && c < 4;
    }
}