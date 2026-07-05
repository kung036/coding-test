import java.util.*;

class Solution {
    static char[][] grid;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = storage[i].charAt(j);
            }
        }

        for (String req : requests) {
            char target = req.charAt(0);
            if (req.length() == 2) {
                // 크레인: 해당 종류 전부 제거
                crane(target);
            } else {
                // 지게차: 외부 접근 가능한 것만 제거
                forklift(target);
            }
        }

        // 남은 컨테이너 수 카운트
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != '\0') count++;
            }
        }
        return count;
    }

    // 크레인: 해당 종류 전부 제거
    private void crane(char target) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == target) grid[i][j] = '\0';
            }
        }
    }

    // 지게차: 외부와 연결된 빈 공간에서 BFS로 접근 가능한 target 제거
    private void forklift(char target) {
        boolean[][] visited = new boolean[n + 2][m + 2];
        Queue<int[]> queue = new ArrayDeque<>();

        // 외부 시작점 (0,0) -> 패딩 영역
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        // 제거 대상 좌표 저장
        List<int[]> toRemove = new ArrayList<>();

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dx[d];
                int nc = c + dy[d];

                if (nr < 0 || nr >= n + 2 || nc < 0 || nc >= m + 2) continue;
                if (visited[nr][nc]) continue;

                // 패딩 좌표 -> 실제 그리드 좌표 변환
                int gr = nr - 1, gc = nc - 1;

                if (gr >= 0 && gr < n && gc >= 0 && gc < m) {
                    // 실제 그리드 내부
                    if (grid[gr][gc] == target) {
                        toRemove.add(new int[]{gr, gc});
                        visited[nr][nc] = true;
                        // target은 제거 대상이지만 통과 불가 (BFS 더 진행 안 함)
                        continue;
                    } else if (grid[gr][gc] != '\0') {
                        // 다른 컨테이너 -> 막힘
                        visited[nr][nc] = true;
                        continue;
                    }
                }

                // 빈 칸 or 패딩 영역 -> 계속 탐색
                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc});
            }
        }

        for (int[] pos : toRemove) {
            grid[pos[0]][pos[1]] = '\0';
        }
    }
}