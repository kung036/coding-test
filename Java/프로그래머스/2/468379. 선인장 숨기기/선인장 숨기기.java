import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        final int INF = Integer.MAX_VALUE;
        int[][] grid = new int[m][n];
        for (int[] row : grid) Arrays.fill(row, INF);
        for (int i = 0; i < drops.length; i++) {
            grid[drops[i][0]][drops[i][1]] = i + 1;
        }

        // 가로 방향 슬라이딩 윈도우 최솟값 (윈도우 크기 w)
        int outW = n - w + 1;
        int[][] hmin = new int[m][outW];
        for (int r = 0; r < m; r++) {
            int[] dq = new int[n];
            int head = 0, tail = 0;
            for (int c = 0; c < n; c++) {
                while (tail > head && grid[r][dq[tail - 1]] >= grid[r][c]) tail--;
                dq[tail++] = c;
                if (dq[head] <= c - w) head++;
                if (c >= w - 1) hmin[r][c - w + 1] = grid[r][dq[head]];
            }
        }

        // 세로 방향 슬라이딩 윈도우 최솟값 (윈도우 크기 h)
        int outH = m - h + 1;
        int[][] res = new int[outH][outW];
        for (int c = 0; c < outW; c++) {
            int[] dq = new int[m];
            int head = 0, tail = 0;
            for (int r = 0; r < m; r++) {
                while (tail > head && hmin[dq[tail - 1]][c] >= hmin[r][c]) tail--;
                dq[tail++] = r;
                if (dq[head] <= r - h) head++;
                if (r >= h - 1) res[r - h + 1][c] = hmin[dq[head]][c];
            }
        }

        int bestVal = -1, bestR = 0, bestC = 0;
        for (int r = 0; r < outH; r++) {
            for (int c = 0; c < outW; c++) {
                if (res[r][c] > bestVal) {
                    bestVal = res[r][c];
                    bestR = r;
                    bestC = c;
                }
            }
        }
        return new int[]{bestR, bestC};
    }
}