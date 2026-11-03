import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int answer = 0;
        boolean changed = true;

        while (changed) {
            changed = false;

            // 블록별 바운딩 박스: minR, minC, maxR, maxC
            int[][] box = new int[201][4];
            for (int[] b : box) {
                b[0] = n; b[1] = n; b[2] = -1; b[3] = -1;
            }
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int id = board[r][c];
                    if (id == 0) continue;
                    box[id][0] = Math.min(box[id][0], r);
                    box[id][1] = Math.min(box[id][1], c);
                    box[id][2] = Math.max(box[id][2], r);
                    box[id][3] = Math.max(box[id][3], c);
                }
            }

            for (int id = 1; id <= 200; id++) {
                if (box[id][2] == -1) continue; // 이미 없거나 존재하지 않는 블록
                if (canRemove(board, id, box[id])) {
                    for (int r = box[id][0]; r <= box[id][2]; r++) {
                        for (int c = box[id][1]; c <= box[id][3]; c++) {
                            if (board[r][c] == id) board[r][c] = 0;
                        }
                    }
                    answer++;
                    changed = true;
                }
            }
        }
        return answer;
    }

    // 박스 안의 블록이 아닌 칸은 전부 빈칸이고, 그 칸 위로 막힌 게 없어야 함
    private boolean canRemove(int[][] board, int id, int[] b) {
        for (int r = b[0]; r <= b[2]; r++) {
            for (int c = b[1]; c <= b[3]; c++) {
                if (board[r][c] == id) continue;
                if (board[r][c] != 0) return false;
                for (int k = 0; k < r; k++) {
                    if (board[k][c] != 0) return false;
                }
            }
        }
        return true;
    }
}