import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        int[][] groupId = new int[n][m];  // 각 칸의 덩어리 ID
        int[] groupSize = new int[n * m + 1]; // 덩어리 ID별 크기
        int id = 1;

        // BFS로 석유 덩어리 탐색 및 ID 부여
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && groupId[i][j] == 0) {
                    groupSize[id] = bfs(land, groupId, i, j, id, n, m);
                    id++;
                }
            }
        }

        // 각 열마다 시추 시 얻을 수 있는 석유량 계산
        int answer = 0;
        for (int j = 0; j < m; j++) {
            Set<Integer> visited = new HashSet<>();
            int total = 0;
            for (int i = 0; i < n; i++) {
                int gId = groupId[i][j];
                if (gId != 0 && visited.add(gId)) {
                    total += groupSize[gId];
                }
            }
            answer = Math.max(answer, total);
        }

        return answer;
    }

    private int bfs(int[][] land, int[][] groupId, int si, int sj, int id, int n, int m) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{si, sj});
        groupId[si][sj] = id;
        int size = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            size++;

            for (int d = 0; d < 4; d++) {
                int ni = cur[0] + dx[d];
                int nj = cur[1] + dy[d];

                if (ni < 0 || ni >= n || nj < 0 || nj >= m) continue;
                if (land[ni][nj] == 0 || groupId[ni][nj] != 0) continue;

                groupId[ni][nj] = id;
                queue.add(new int[]{ni, nj});
            }
        }

        return size;
    }
}