import java.util.*;

class Solution {
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        List<int[]>[] g = new List[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        for (int[] r : roads) {
            g[r[0]].add(new int[]{r[1], r[2], 0}); // 정방향
            g[r[1]].add(new int[]{r[0], r[2], 1}); // 역방향
        }

        int[] bit = new int[n + 1];
        for (int i = 0; i < traps.length; i++) bit[traps[i]] = 1 << i;

        int[][] dist = new int[n + 1][1 << traps.length];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[start][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, start, 0}); // 비용, 방, 함정상태

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], u = cur[1], mask = cur[2];
            if (u == end) return cost;
            if (cost > dist[u][mask]) continue;

            for (int[] e : g[u]) {
                int v = e[0];
                int reversed = ((mask & bit[u]) != 0 ? 1 : 0) ^ ((mask & bit[v]) != 0 ? 1 : 0);
                if (reversed != e[2]) continue;

                int next = mask ^ bit[v];
                int nc = cost + e[1];
                if (nc < dist[v][next]) {
                    dist[v][next] = nc;
                    pq.add(new int[]{nc, v, next});
                }
            }
        }
        return -1;
    }
}