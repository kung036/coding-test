import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int K = n + 2;

        // 테두리를 벽으로 감싼 지도 (좌표 1~n 사용)
        int[][] map = new int[K][K];
        for (int[] row : map) Arrays.fill(row, 1);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                map[i + 1][j + 1] = board[i][j];

        Queue<int[]> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.add(new int[]{1, 1, 1, 2, 0});
        visited.add(key(1, 1, 1, 2, K));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r1 = cur[0], c1 = cur[1], r2 = cur[2], c2 = cur[3], t = cur[4];

            if ((r1 == n && c1 == n) || (r2 == n && c2 == n)) return t;

            List<int[]> next = new ArrayList<>();

            // 평행이동
            for (int k = 0; k < 4; k++) {
                int nr1 = r1 + dr[k], nc1 = c1 + dc[k];
                int nr2 = r2 + dr[k], nc2 = c2 + dc[k];
                if (map[nr1][nc1] == 0 && map[nr2][nc2] == 0)
                    next.add(new int[]{nr1, nc1, nr2, nc2});
            }

            // 회전 (두 칸 각각이 축이 될 수 있음)
            for (int d = -1; d <= 1; d += 2) {
                if (r1 == r2) { // 가로 → 세로: 위/아래 두 칸이 비어야 함
                    if (map[r1 + d][c1] == 0 && map[r2 + d][c2] == 0) {
                        next.add(new int[]{r1, c1, r1 + d, c1});
                        next.add(new int[]{r2, c2, r2 + d, c2});
                    }
                } else {        // 세로 → 가로: 좌/우 두 칸이 비어야 함
                    if (map[r1][c1 + d] == 0 && map[r2][c2 + d] == 0) {
                        next.add(new int[]{r1, c1, r1, c1 + d});
                        next.add(new int[]{r2, c2, r2, c2 + d});
                    }
                }
            }

            for (int[] nx : next) {
                int a = nx[0], b = nx[1], c = nx[2], e = nx[3];
                // (a,b)가 앞서도록 정렬
                if (a > c || (a == c && b > e)) {
                    int tr = a, tc = b;
                    a = c; b = e; c = tr; e = tc;
                }
                if (visited.add(key(a, b, c, e, K)))
                    q.add(new int[]{a, b, c, e, t + 1});
            }
        }
        return -1;
    }

    private int key(int r1, int c1, int r2, int c2, int K) {
        return ((r1 * K + c1) * K + r2) * K + c2;
    }
}