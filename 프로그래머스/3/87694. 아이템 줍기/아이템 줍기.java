import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 좌표를 2배로 키워서 ㄷ자 모양 좁은 통로 문제를 방지
        int[][] map = new int[102][102];

        for (int[] r : rectangle) {
            int x1 = r[0] * 2, y1 = r[1] * 2, x2 = r[2] * 2, y2 = r[3] * 2;
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    if (x > x1 && x < x2 && y > y1 && y < y2) {
                        map[x][y] = 2;                  // 내부
                    } else if (map[x][y] != 2) {
                        map[x][y] = 1;                  // 테두리
                    }
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        boolean[][] visited = new boolean[102][102];
        Queue<int[]> q = new LinkedList<>();
        int sx = characterX * 2, sy = characterY * 2;
        int ex = itemX * 2, ey = itemY * 2;

        q.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == ex && cur[1] == ey) return cur[2] / 2;

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx < 0 || ny < 0 || nx > 101 || ny > 101) continue;
                if (visited[nx][ny] || map[nx][ny] != 1) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, cur[2] + 1});
            }
        }
        return 0;
    }
}