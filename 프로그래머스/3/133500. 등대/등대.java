import java.util.*;

class Solution {
    public int solution(int n, int[][] lighthouse) {
        List<Integer>[] g = new List[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        for (int[] e : lighthouse) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        // 1번을 루트로 BFS: 방문 순서와 부모 기록
        int[] parent = new int[n + 1];
        int[] order = new int[n];
        int head = 0, tail = 0;
        order[tail++] = 1;
        while (head < tail) {
            int cur = order[head++];
            for (int nx : g[cur]) {
                if (nx != parent[cur]) {
                    parent[nx] = cur;
                    order[tail++] = nx;
                }
            }
        }

        // 역순(리프 → 루트)으로 처리
        boolean[] on = new boolean[n + 1];
        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            int cur = order[i];
            int p = parent[cur];
            if (p != 0 && !on[cur] && !on[p]) {
                on[p] = true;
                answer++;
            }
        }
        return answer;
    }
}