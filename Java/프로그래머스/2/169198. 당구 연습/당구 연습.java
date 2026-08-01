class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int tx = balls[i][0];
            int ty = balls[i][1];
            long best = Long.MAX_VALUE;

            boolean sameRow = (ty == startY);
            boolean sameCol = (tx == startX);

            // 왼쪽 벽 (x = 0)
            if (!(sameRow && tx < startX)) {
                long dx = tx + startX;
                long dy = ty - startY;
                best = Math.min(best, dx * dx + dy * dy);
            }
            // 오른쪽 벽 (x = m)
            if (!(sameRow && tx > startX)) {
                long dx = tx - (2L * m - startX);
                long dy = ty - startY;
                best = Math.min(best, dx * dx + dy * dy);
            }
            // 아래쪽 벽 (y = 0)
            if (!(sameCol && ty < startY)) {
                long dx = tx - startX;
                long dy = ty + startY;
                best = Math.min(best, dx * dx + dy * dy);
            }
            // 위쪽 벽 (y = n)
            if (!(sameCol && ty > startY)) {
                long dx = tx - startX;
                long dy = ty - (2L * n - startY);
                best = Math.min(best, dx * dx + dy * dy);
            }

            answer[i] = (int) best;
        }

        return answer;
    }
}