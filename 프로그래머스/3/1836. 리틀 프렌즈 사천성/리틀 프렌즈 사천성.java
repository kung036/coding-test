class Solution {
    char[][] map;

    public String solution(int m, int n, String[] board) {
        map = new char[m][];
        int[][] pos = new int[26][4];
        int[] cnt = new int[26];
        boolean[] alive = new boolean[26];
        int remain = 0;

        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
            for (int j = 0; j < n; j++) {
                char c = map[i][j];
                if (c >= 'A' && c <= 'Z') {
                    int k = c - 'A';
                    pos[k][cnt[k] * 2] = i;
                    pos[k][cnt[k] * 2 + 1] = j;
                    if (cnt[k]++ == 0) {
                        alive[k] = true;
                        remain++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (remain > 0) {
            boolean removed = false;
            for (int k = 0; k < 26; k++) {
                if (!alive[k]) continue;
                int r1 = pos[k][0], c1 = pos[k][1];
                int r2 = pos[k][2], c2 = pos[k][3];
                char ch = (char) ('A' + k);

                if (canConnect(r1, c1, r2, c2, ch)) {
                    map[r1][c1] = '.';
                    map[r2][c2] = '.';
                    alive[k] = false;
                    remain--;
                    sb.append(ch);
                    removed = true;
                    break; // 다시 A부터 확인
                }
            }
            if (!removed) return "IMPOSSIBLE";
        }
        return sb.toString();
    }

    // 꺾임 1번 이하로 연결 가능한지
    boolean canConnect(int r1, int c1, int r2, int c2, char ch) {
        // 1) 가로(r1행) → 세로(c2열)
        if (rowClear(r1, c1, c2, ch) && colClear(c2, r1, r2, ch)) return true;
        // 2) 세로(c1열) → 가로(r2행)
        if (colClear(c1, r1, r2, ch) && rowClear(r2, c1, c2, ch)) return true;
        return false;
    }

    boolean rowClear(int r, int ca, int cb, char ch) {
        for (int c = Math.min(ca, cb); c <= Math.max(ca, cb); c++) {
            if (map[r][c] != '.' && map[r][c] != ch) return false;
        }
        return true;
    }

    boolean colClear(int c, int ra, int rb, char ch) {
        for (int r = Math.min(ra, rb); r <= Math.max(ra, rb); r++) {
            if (map[r][c] != '.' && map[r][c] != ch) return false;
        }
        return true;
    }
}