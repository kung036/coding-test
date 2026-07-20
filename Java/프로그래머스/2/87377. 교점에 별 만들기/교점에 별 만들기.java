import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        int n = line.length;
        List<long[]> points = new ArrayList<>();

        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            long A1 = line[i][0], B1 = line[i][1], C1 = line[i][2];
            for (int j = i + 1; j < n; j++) {
                long A2 = line[j][0], B2 = line[j][1], C2 = line[j][2];

                long denom = A1 * B2 - A2 * B1;
                if (denom == 0) continue; // 평행하거나 같은 직선

                long numX = B1 * C2 - B2 * C1;
                long numY = A2 * C1 - A1 * C2;

                // 정수 좌표인 경우만 채택
                if (numX % denom == 0 && numY % denom == 0) {
                    long x = numX / denom;
                    long y = numY / denom;
                    points.add(new long[]{x, y});

                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);
                }
            }
        }

        int width = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);

        char[][] grid = new char[height][width];
        for (char[] row : grid) Arrays.fill(row, '.');

        for (long[] p : points) {
            int col = (int)(p[0] - minX);
            int row = (int)(maxY - p[1]); // y가 클수록 위쪽 행(row 0)
            grid[row][col] = '*';
        }

        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(grid[i]);
        }

        return answer;
    }
}