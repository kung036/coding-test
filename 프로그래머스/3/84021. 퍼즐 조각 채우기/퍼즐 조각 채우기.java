import java.util.*;

class Solution {
    private int n;
    private final int[] dr = {1, -1, 0, 0};
    private final int[] dc = {0, 0, 1, -1};

    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;

        // 게임 보드의 빈칸(0) 덩어리, 테이블의 퍼즐 조각(1) 덩어리 추출
        List<List<int[]>> blanks = extract(game_board, 0);
        List<List<int[]>> pieces = extract(table, 1);

        boolean[] used = new boolean[pieces.size()];
        int answer = 0;

        for (List<int[]> blank : blanks) {
            for (int i = 0; i < pieces.size(); i++) {
                if (used[i] || pieces.get(i).size() != blank.size()) continue;
                if (matches(blank, pieces.get(i))) {
                    used[i] = true;
                    answer += blank.size();
                    break;
                }
            }
        }
        return answer;
    }

    // target 값으로 연결된 영역들을 BFS로 찾아 정규화된 좌표 목록으로 반환
    private List<List<int[]>> extract(int[][] board, int target) {
        boolean[][] visited = new boolean[n][n];
        List<List<int[]>> shapes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != target || visited[i][j]) continue;

                List<int[]> cells = new ArrayList<>();
                Deque<int[]> queue = new ArrayDeque<>();
                queue.add(new int[]{i, j});
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    cells.add(cur);
                    for (int d = 0; d < 4; d++) {
                        int nr = cur[0] + dr[d];
                        int nc = cur[1] + dc[d];
                        if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                        if (visited[nr][nc] || board[nr][nc] != target) continue;
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
                shapes.add(normalize(cells));
            }
        }
        return shapes;
    }

    // 최소 행/열을 (0,0)으로 옮기고 정렬해서 모양 비교가 가능하게 만듦
    private List<int[]> normalize(List<int[]> cells) {
        int minR = Integer.MAX_VALUE, minC = Integer.MAX_VALUE;
        for (int[] c : cells) {
            minR = Math.min(minR, c[0]);
            minC = Math.min(minC, c[1]);
        }
        List<int[]> result = new ArrayList<>();
        for (int[] c : cells) {
            result.add(new int[]{c[0] - minR, c[1] - minC});
        }
        result.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        return result;
    }

    // 90도 회전: (r, c) -> (c, -r) 후 정규화
    private List<int[]> rotate(List<int[]> cells) {
        List<int[]> rotated = new ArrayList<>();
        for (int[] c : cells) {
            rotated.add(new int[]{c[1], -c[0]});
        }
        return normalize(rotated);
    }

    // 조각을 0/90/180/270도 회전하며 빈칸과 같은 모양인지 확인
    private boolean matches(List<int[]> blank, List<int[]> piece) {
        List<int[]> cur = piece;
        for (int k = 0; k < 4; k++) {
            if (sameShape(blank, cur)) return true;
            cur = rotate(cur);
        }
        return false;
    }

    private boolean sameShape(List<int[]> a, List<int[]> b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) return false;
        }
        return true;
    }
}