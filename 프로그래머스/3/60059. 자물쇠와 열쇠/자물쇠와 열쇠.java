class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        int size = N + 2 * (M - 1);

        int[][] board = new int[size][size];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i + M - 1][j + M - 1] = lock[i][j];
            }
        }

        for (int r = 0; r < 4; r++) {
            key = rotate(key);
            for (int x = 0; x <= size - M; x++) {
                for (int y = 0; y <= size - M; y++) {
                    apply(board, key, x, y, 1);
                    if (check(board, N, M)) return true;
                    apply(board, key, x, y, -1);
                }
            }
        }
        return false;
    }

    private void apply(int[][] board, int[][] key, int x, int y, int sign) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                board[x + i][y + j] += sign * key[i][j];
            }
        }
    }

    private boolean check(int[][] board, int N, int M) {
        for (int i = M - 1; i < M - 1 + N; i++) {
            for (int j = M - 1; j < M - 1 + N; j++) {
                if (board[i][j] != 1) return false;
            }
        }
        return true;
    }

    private int[][] rotate(int[][] key) {
        int M = key.length;
        int[][] res = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                res[j][M - 1 - i] = key[i][j];
            }
        }
        return res;
    }
}