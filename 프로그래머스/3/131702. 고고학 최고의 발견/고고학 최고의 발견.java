class Solution {
    // 자기 자신, 상, 하, 좌, 우
    static final int[] dx = {0, -1, 1, 0, 0};
    static final int[] dy = {0, 0, 0, -1, 1};

    public int solution(int[][] clockHands) {
        int n = clockHands.length;
        int answer = Integer.MAX_VALUE;
        int total = 1 << (2 * n); // 4^n

        for (int mask = 0; mask < total; mask++) {
            int[][] a = new int[n][];
            for (int i = 0; i < n; i++) a[i] = clockHands[i].clone();

            int cnt = 0;

            // 첫 행: mask로 각 칸의 회전 횟수(0~3) 결정
            for (int j = 0; j < n; j++) {
                int k = (mask >> (2 * j)) & 3;
                if (k > 0) {
                    rotate(a, 0, j, k, n);
                    cnt += k;
                }
            }

            // 나머지 행: 윗줄을 0으로 만들도록 회전 횟수가 결정됨
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int k = (4 - a[i - 1][j]) % 4;
                    if (k > 0) {
                        rotate(a, i, j, k, n);
                        cnt += k;
                    }
                }
            }

            // 마지막 행이 모두 12시인지 확인
            boolean ok = true;
            for (int j = 0; j < n; j++) {
                if (a[n - 1][j] != 0) {
                    ok = false;
                    break;
                }
            }

            if (ok) answer = Math.min(answer, cnt);
        }

        return answer;
    }

    private void rotate(int[][] a, int x, int y, int k, int n) {
        for (int d = 0; d < 5; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            a[nx][ny] = (a[nx][ny] + k) % 4;
        }
    }
}